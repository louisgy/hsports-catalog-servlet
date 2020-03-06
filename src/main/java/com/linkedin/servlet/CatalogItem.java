package com.linkedin.servlet;

public class CatalogItem {
	private String name;
	private String manufacturer;
	private String sku;
	
	CatalogItem(String name, String manufacturer, String sku) {
		super();
		this.name = name;
		this.manufacturer = manufacturer;
		this.sku = sku;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}

	public String getSku() {
		return sku;
	}

	public void setSku(String sku) {
		this.sku = sku;
	}
	
	
}
