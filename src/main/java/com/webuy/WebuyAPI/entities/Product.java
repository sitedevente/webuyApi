package com.webuy.WebuyAPI.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Product implements Serializable {
	@Id
	@GeneratedValue
	private Long id;
	private String name;
	private int stock;
	
	//@ManyToOne(fetch = FetchType.LAZY)
	private Shop shop;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	/*
	 * public Shop getShop() { return shop; }
	 * 
	 * public void setShop(Shop shop) { this.shop = shop; }
	 */	
}
