package com.visa.prj.client;

import java.util.Arrays;

public class ArrayClient {

	public static void main(String[] args) {
		String[] names = { "Jhon", "Reese", "Flinch" };

		/*
		 * Arrays.sort(names, new Comparator<String>){
		 * 
		 * @Override public int compare(String n1, StriNG n2) { return n2.lenght() -
		 * n1.length();
		 * 
		 * } }
		 */

		Arrays.sort(names, (o1, o2) -> o1.length() - o2.length());

		for (String string : names) {
			System.out.println(string);
		}

	}

}
