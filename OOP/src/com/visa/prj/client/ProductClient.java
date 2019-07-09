package com.visa.prj.client;

import java.lang.reflect.Method;

import com.visa.prj.entity.Mobile;
import com.visa.prj.entity.Product;
import com.visa.prj.entity.Tv;

public class ProductClient {

	public static void main(String[] args) {
		Product[] products = new Product[4];
		products[0] = new Tv(153, "Samsung", 32000, "32");
		products[1] = new Mobile(154, "Sony", 12000, "3G");
		products[2] = new Tv(155, "Mi", 72000, "72");
		products[3] = new Mobile(156, "Xiomi", 22000, "4G");

		// printExpensive(products);
		// printInfo(products);
		printInfoOCP(products);
	}

	/**
	 * Print details using OCP principle using reflexive principle
	 * 
	 * @param products
	 */
	public static void printInfoOCP(Product[] products) {
		for (Product product : products) {
			Class c = product.getClass();
			Method[] methods = c.getMethods();

			for (Method m : methods) {
				if (m.getName().startsWith("get")) {
					try {
						Object ret = m.invoke(product);
						System.out.println(ret);
					} catch (Exception e) {

					}
				}
			}
		}
	}

	private static void printInfo(Product[] products) {
		for (Product product : products) {
			System.out.println(product.getName() + " " + product.getPrice());

			if (product instanceof Tv) {
				Tv t = (Tv) product;
				System.out.println("Screen Type " + t.getScreenType());
			}
			if (product.getClass() == Mobile.class) {
				Mobile m = (Mobile) product;
				System.out.println("Connection " + m.getConnection());
			}
		}
	}

	private static void printExpensive(Product[] products) {
		for (Product product : products) {
			if (product.isExpensive()) {
				System.out.println(product.getName() + " is expensive");
			}

		}

	}

}
