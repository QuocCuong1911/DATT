package com.fpoly.service;

import java.util.List;

import com.fpoly.entity.Categories;

public interface CategoriesService {

	void deleteCategories(int id);
	
	Categories createCategories(Categories cate);
	
	Boolean exitCategories(int id);
	
	List<Categories> findAllCategories();
}
