package com.fpoly.service;

import com.fpoly.entity.Product;

public interface ProductService {
	void deleteProduct(int id);
	Boolean exitProductById(int id);
	Boolean checkEmtyCategories(int id);
}
