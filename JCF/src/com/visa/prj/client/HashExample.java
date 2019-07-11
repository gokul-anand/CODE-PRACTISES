package com.visa.prj.client;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class HashExample {

	public static void main(String[] args) {
		
		Map<String, Double> map = new HashMap<>();
		
		map.put("Java",83.23);
		map.put("c++",93.33);
		
		Set<String> keys = map.keySet();
		for (String key : keys) {
			System.out.println(key+ " " +map.get(key));
		}
		
		keys.forEach(System.out::println);
		
		map.forEach((k,v) -> System.out.println(k+" : "+v) );
	}

}
