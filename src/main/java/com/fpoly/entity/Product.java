package com.fpoly.entity;

import java.io.Serializable;

import org.hibernate.annotations.ManyToAny;

import jakarta.annotation.Generated;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "product")
@SuppressWarnings("serial")
public class Product implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "product_id")
	Integer id;
	
	@Column(name = "name")
	String name;
	
	@Column(name = "description")
	String description;
	
	@Column(name = "price")
	Double price;
	
	@Column(name = "quantity")
	Integer quantity;
	
	@ManyToOne
	@JoinColumn(name = "category_id")
	Categories cateId;
}
