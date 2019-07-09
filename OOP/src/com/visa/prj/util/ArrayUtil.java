package com.visa.prj.util;

import java.util.Arrays;

public class ArrayUtil {

	public static int getSum(int[] data) {
		int sum = 0;

		for (int i = 0; i < data.length; i++) {
			sum += data[i];
		}

		return sum;
	}

	public static void sort(int[] elems) {

		Arrays.sort(elems);

	}

	public static void sort(Comparable[] elems) {
		for (int i = 0; i < elems.length; i++) {
			for (int j = 0; j < elems.length; j++) {
				if (elems[i].compareTo(elems[j]) > 0) {
					Comparable temp = elems[i];
					elems[i] = elems[j];
					elems[j] = temp;
				}
			}

		}
	}

	public static int getCount(int[] elems, int no) {
		int count = 0;

		for (int i = 0; i < elems.length; i++) {
			if (elems[i] == no)
				count += 1;
		}

		return count;
	}

	public static int[] convert(int[][] elems) {

		int size = 0;

		for (int i = 0; i < elems.length; i++)
			for (int j = 0; j < elems[i].length; j++) {
				size += 1;
			}

		int[] result = new int[size];
		int k = 0;
		for (int i = 0; i < elems.length; i++)
			for (int j = 0; j < elems[i].length; j++) {
				result[k] = elems[i][j];
				k += 1;
			}

		return result;
	}

}
