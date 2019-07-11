package com.visa.prj.client;

import java.util.Map;
import java.util.WeakHashMap;

public class WeakExample {
	public static void main(String[] args) {
		Map<String, Double> map = new WeakHashMap<>();
		String s = new String("Java");
		map.put(s, 83.23);
		
		s=null;
		System.gc();
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println(map.get("Java"));
		

	}
}
