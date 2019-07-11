package com.visa.prj.client;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import javax.swing.plaf.synth.SynthOptionPaneUI;

import com.visa.prj.entity.Product;

public class ListClient {
	public static void main(String[] args) {
		List<Product> products = new ArrayList<>();
		products.add(new Product(645, "Hp Laptop", 135000.00, "computer", 100));
		products.add(new Product(224, "iPhone", 98000.00, "mobile", 500));
		products.add(new Product(834, "Logitech Mouse", 600.00, "computer", 300));
		products.add(new Product(5, "Sony Bravia", 125000.00, "tv", 900));
		products.add(new Product(912, "One Plus", 32000.00, "mobile", 100));
		products.add(new Product(88, "HP Printer", 19000.00, "computer", 100));

		List<Product> cProducts = new CopyOnWriteArrayList(products);
		Collections.sort(products, (o1, o2) -> Double.compare(o1.getPrice(), o2.getPrice()));

		for (Product product : products) {
			System.out.println(product);
		}

		Iterator<Product> it = cProducts.iterator();
		products.add(new Product());

		System.out.println("***************");

		while (it.hasNext()) {
			Product p = it.next();
			System.out.println(p);
		}

		System.out.println("***************");

		for (Product product : cProducts) {
			products.add(new Product());
			System.out.println(product);
		}

	}

}
