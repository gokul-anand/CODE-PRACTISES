package com.visa.prj.client;

import java.util.HashMap;
import java.util.Map;

public class WordFrequency {

	public static void main(String[] args) {
		String str = String.join(" ", args);
		Map<String, Integer> map= getWordFrequency(str);
		
		map.forEach((k,v)->System.out.println(k+" ,"+v));
		
	}

	private static Map<String, Integer> getWordFrequency(String str) {
		Map<String, Integer> map = new HashMap<>();
		
		String[] words = str.split(" ");
		
		for (String word : words) {
			if(map.get(word)==null) {
				map.put(word,1);
			}
			else {
				map.put(word, map.get(word)+1 );
			}
			
		}
		
  		return map;
	}

}
