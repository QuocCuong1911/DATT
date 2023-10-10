package com.fpoly.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fpoly.entity.Categories;
import com.fpoly.repository.CatgoriesRepository;
import com.fpoly.service.CategoriesService;
import com.fpoly.service.ProductService;

@Service
public class CategoriesServiceImpl implements CategoriesService{

	@Autowired
	CatgoriesRepository cateRepo;
	
	
	@Override
	public void deleteCategories(int id) {
		cateRepo.deleteById(id);
	}

	

	@Override
	public Boolean exitCategories(int id) {
		// TODO Auto-generated method stub
		return cateRepo.existsById(id);
	}



	@Override
	public Categories createCategories(Categories cate) {
		// TODO Auto-generated method stub
		return cateRepo.save(cate);
	}



	@Override
	public List<Categories> findAllCategories() {
		// TODO Auto-generated method stub
		return cateRepo.findAll();
	}

}
