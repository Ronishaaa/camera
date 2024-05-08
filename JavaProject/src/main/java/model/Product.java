package model;

import java.io.Serializable;

public class Product implements Serializable{
	
	
	
	
	private static final long serialVersionUID = 1L;
	private int product_id;
	public int getProduct_id() {
		return product_id;
	}

	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}
	
	private String product_name;
	private String product_description;
	private int unit_price;
	private int stock;
	private byte[] product_image;


	public Product() {

	}


	public String getProduct_name() {
		return product_name;
	}


	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}


	public String getProduct_description() {
		return product_description;
	}


	public void setProduct_description(String product_description) {
		this.product_description = product_description;
	}


	public int getUnit_price() {
		return unit_price;
	}


	public void setUnit_price(int unit_price) {
		this.unit_price = unit_price;
	}


	public int getStock() {
		return stock;
	}


	public void setStock(int stock) {
		this.stock = stock;
	}

	public byte[] getProduct_image() {
		return product_image;
	}

	public void setProduct_image(byte[] product_image) {
		this.product_image = product_image;
	}

	
	
}