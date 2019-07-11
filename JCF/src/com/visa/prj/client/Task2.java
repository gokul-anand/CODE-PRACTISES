package com.visa.prj.client;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

import com.visa.prj.entity.Product;

public class Task2 {

	public static void main(String[] args) {
		Product p = new Product(645, "Hp Laptop", 135000.00, "computer", 100);

		Map<String, Object> map = storeInfo(p);

		map.forEach((k, v) -> System.out.println(k + " " + v));

	}

	private static Map<String, Object> storeInfo(Product p) {
		Class clas = p.getClass();
		Method[] methods = clas.getMethods();
		Map<String, Object> map = new HashMap<>();
		for (Method m : methods) {
			if (m.getName().startsWith("get") && m.getName().equals("getClass") != true) {
				try {
					Object ret = m.invoke(p);
					String id = m.getName().replace("get", "");

					map.put(id, ret);
				} catch (Exception e) {

				}
			}
		}
		return map;

	}

}
