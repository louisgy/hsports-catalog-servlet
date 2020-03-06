package com.linkedin.servlet;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Catalog {

	public static Map<String,CatalogItem> catalogItems = new HashMap<>();
	
	public static void addItem(CatalogItem CatalogItem) {
		catalogItems.put(CatalogItem.getSku(),CatalogItem);
	}
	
	public static CatalogItem getItem(String sku) {
		return catalogItems.get("sku");
	}
	
	public static List<CatalogItem> getItems(){
		return new ArrayList<CatalogItem>(catalogItems.values());
	}
}


