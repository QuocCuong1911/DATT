package com.fpoly.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fpoly.entity.Categories;
import com.fpoly.service.CategoriesService;
import com.fpoly.service.ProductService;

import jakarta.validation.Valid;

@CrossOrigin(origins = "*")
@RestController
public class CategoriesRestController {

	@Autowired
	CategoriesService cateService;
	@Autowired
	ProductService prService;
	
	@GetMapping("/cate/getAll")
	public ResponseEntity<List<Categories>> getAllCategories(){
		return ResponseEntity.ok(cateService.findAllCategories());
	}
	
	@PostMapping("/cate/create")
	public ResponseEntity<Categories> createCate(@Valid @RequestBody Categories cate){
	
		return ResponseEntity.ok(cateService.createCategories(cate));
	}
	
	@DeleteMapping("/cate/delete/{id}")
	public ResponseEntity<String> deleteCate(@PathVariable("id") String id){
		int idParse;
		try {
			idParse = Integer.parseInt(id);
		} catch (Exception e) {
			return ResponseEntity.badRequest().build();
		}
		
		if(!cateService.exitCategories(idParse)) {
			return ResponseEntity.notFound().build();
		}else if(!prService.checkEmtyCategories(idParse)) {
			return ResponseEntity.badRequest().build();
		}
		cateService.deleteCategories(idParse);
		return ResponseEntity.ok("Xóa loại sản phẩm thành công");
	}
}
