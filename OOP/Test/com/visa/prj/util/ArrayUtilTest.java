package com.visa.prj.util;

import static org.junit.Assert.*;

import org.junit.Test;

public class ArrayUtilTest {

	@Test
	public void testGetSum() {
		int[] data = {1,2,3,4,5};
		int expected = 15;
		assertEquals(expected,ArrayUtil.getSum(data));
	}

	@Test
	public void testSort() {
		int[] data = {1,2,3,5,4};
		int[] expected = {1,2,3,4,5};
		ArrayUtil.sort(data);
		assertArrayEquals(expected,data);
			
	}

	@Test
	public void testGetCount() {
		int[] data = {1,2,3,2,5};
		int expected = 2;
		assertEquals(expected,ArrayUtil.getCount(data,2));

	}

	@Test
	public void testConvert() {
		int[][] data = { 
						{1,2,3},
						{2,84,12},
						{34,23,23}
					};
		int[] expected = {1,2,3,2,84,12,34,23,23};		
		assertArrayEquals(expected, ArrayUtil.convert(data));
		
	}
}
