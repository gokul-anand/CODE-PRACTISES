package com.visa.prj.client;

import java.util.List;

import com.visa.prj.dao.FetchException;
import com.visa.prj.dao.ProductDao;
import com.visa.prj.dao.ProductDaoImpl;
import com.visa.prj.entity.Product;

public class ListProducts {
	public static void main(String[] args) {
		ProductDao productDao = new ProductDaoImpl();
		List<Product> prods;
		try {
			prods = productDao.getProduct();
			for (Product product : prods) {
				System.out.println(product.getName()+ " "+product.getPrice());
			}
		} catch (FetchException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
}
