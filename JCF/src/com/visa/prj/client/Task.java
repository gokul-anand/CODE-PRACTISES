package com.visa.prj.client;

import java.util.HashSet;
import java.util.Set;

public class Task {
	public static void main(String[] args) {
		String string = "We are the world we are the children";
		
		String[] words = string.split(" ");
		
		Set<String> set = new HashSet<>( words.length );
		Set<String> uniqueWords = new HashSet<>( words.length );
		Set<String> duplicateWords = new HashSet<>( words.length );
		
		
		for (String word: words) {
			if(set.add(word)) {
				uniqueWords.add(word);
			}
			else {
				duplicateWords.add(word);
			}
		}
		
		uniqueWords.removeAll(duplicateWords);
		
		System.out.println("duplicate words");
		for (String word : duplicateWords) {
			System.out.println(word);
		}
		
		System.out.println("unique words");	
		for (String word : uniqueWords) {
			System.out.println(word);
		}
		
		
	}

}
