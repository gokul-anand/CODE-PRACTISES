package com.visa.prj.client;

import com.visa.prj.dao.PersistenceException;
import com.visa.prj.dao.ProductDao;
import com.visa.prj.dao.ProductDaoImpl;
import com.visa.prj.entity.Product;

public class AddProduct {

	public static void main(String[] args) {
		ProductDao productDao = new ProductDaoImpl();
		try {
			Product p = new Product (0,"HP Laptop","Laptop",15000,500);
			int id = productDao.addProduct(p);
			System.out.println("Product added! id ="+id);
		} catch (PersistenceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
