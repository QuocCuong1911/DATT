package com.fpoly.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fpoly.entity.Product;
import com.fpoly.repository.ProductRepository;
import com.fpoly.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService{

	@Autowired
	ProductRepository prRepo;
	@Override
	public void deleteProduct(int id) {
		prRepo.deleteById(id);
	}
	@Override
	public Boolean exitProductById(int id) {
		// TODO Auto-generated method stub
		return prRepo.existsById(id);
	}
	@Override
	public Boolean checkEmtyCategories(int id) {
		// TODO Auto-generated method stub
		return prRepo.checkEmtyCategories(id).isEmpty();
	}
	

}
