package com.visa.prj.client;

import com.visa.prj.entity.Mobile;
import com.visa.prj.entity.Product;
import com.visa.prj.entity.Tv;
import com.visa.prj.util.ArrayUtil;

public class SortClient {

	public static void main(String[] args) {
		String[] names = { "aab", "sdf" , "ffe" };
		ArrayUtil.sort(names);
		
		for (String string : names) {
			System.out.println(string);
		}
		
		Product[] products = new Product[4];
		products[0] = new Tv(153, "Samsung", 32000, "32");
		products[1] = new Mobile(156, "Sony", 12000, "3G");
		products[2] = new Tv(155, "Mi", 72000, "72");
		products[3] = new Mobile(155, "Xiomi", 22000, "4G");
		
		ArrayUtil.sort(products);
		for (Product product : products) {
			System.out.println(product);
		}
	}

	@Override
	public String toString() {
		return "SortClient [getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()="
				+ super.toString() + "]";
	}

}
