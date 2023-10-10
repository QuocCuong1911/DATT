package com.fpoly.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.fpoly.entity.Categories;


public interface CatgoriesRepository extends JpaRepository<Categories, Integer>{

	
}
