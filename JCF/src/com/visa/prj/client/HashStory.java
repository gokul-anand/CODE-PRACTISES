package com.visa.prj.client;


import com.visa.prj.entity.Product;

public class HashStory {
	
	public static void main(String[] args) {
		
		Product p1 = new Product(645, "Hp Laptop", 135000.00, "computer", 100);
		Product p2 = new Product(645, "Hp Laptop", 135000.00, "computer", 100);
		
		System.out.println(p1.hashCode()==p2.hashCode());
	}

}
