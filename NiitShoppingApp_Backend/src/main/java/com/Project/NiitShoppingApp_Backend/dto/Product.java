package com.Project.NiitShoppingApp_Backend.dto;

import java.io.Serializable;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="NiitShoppingApp_Product")
public class Product implements Serializable
{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@JsonIgnore
	private String code;
	private String name;
	private String brand;
	@JsonIgnore
	private String description;
	private double unit_price;
	private int quantity;
	@JsonIgnore
	private boolean is_active;
	@JsonIgnore
	private int category_id;
	@JsonIgnore
	private int supplier_id;
	private int purchases;
	private int views;
	
	
	public Product()
	{
		this.code = UUID.randomUUID().toString().substring(26).toUpperCase();
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getCode() {
		return code;
	}


	public void setCode(String code) {
		this.code = code;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getBrand() {
		return brand;
	}


	public void setBrand(String brand) {
		this.brand = brand;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public double getUnit_price() {
		return unit_price;
	}


	public void setUnit_price(double unit_price) {
		this.unit_price = unit_price;
	}


	public int getQuantity() {
		return quantity;
	}


	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}


	public boolean isIs_active() {
		return is_active;
	}


	public void setIs_active(boolean is_active) {
		this.is_active = is_active;
	}


	public int getCategory_id() {
		return category_id;
	}


	public void setCategory_id(int category_id) {
		this.category_id = category_id;
	}


	public int getSupplier_id() {
		return supplier_id;
	}


	public void setSupplier_id(int supplier_id) {
		this.supplier_id = supplier_id;
	}


	public int getPurchases() {
		return purchases;
	}


	public void setPurchases(int purchases) {
		this.purchases = purchases;
	}


	public int getViews() {
		return views;
	}


	public void setViews(int views) {
		this.views = views;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	public Product(int id, String code, String name, String brand, String description, double unit_price, int quantity,
			boolean is_active, int category_id, int supplier_id, int purchases, int views) {
		super();
		this.id = id;
		this.code = code;
		this.name = name;
		this.brand = brand;
		this.description = description;
		this.unit_price = unit_price;
		this.quantity = quantity;
		this.is_active = is_active;
		this.category_id = category_id;
		this.supplier_id = supplier_id;
		this.purchases = purchases;
		this.views = views;
	}
	
	

}
