package com.fpoly.entity;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "categories")
@SuppressWarnings("serial")
public class Categories implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "category_id")
	Integer categoryID;
	
	
	@Column(name = "name")
	@NotNull(message = "Tên không được để trống")
    @Size(max = 100, message = "Tên không được vượt quá 100 ký tự")
    @Pattern(regexp = "^[a-zA-Z0-9\\s]+$", message = "Tên không được chứa ký tự đặc biệt")
	String name;
	
	@Column(name = "brand_id")
	Integer BrandId;
	
	@JsonIgnore
	@OneToMany(mappedBy = "cateId")
	List<Product> productList;
}
