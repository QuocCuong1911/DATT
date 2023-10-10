package com.fpoly.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fpoly.service.ProductService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/product")
public class ProductRestController {

	@Autowired
	ProductService prService;
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteProduct(@PathVariable("id") String id) {
		int idParse;
		try {
			idParse = Integer.parseInt(id);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Đường dẫn không hợp lệ");
		}
		
		if(!prService.exitProductById(idParse)) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Sản phẩm không tồn tại hoặc đã bị xóa");
		}
		
		prService.deleteProduct(idParse);
		return ResponseEntity.ok("Xóa sản phẩm thành công");
	}
}
