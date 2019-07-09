package com.visa.prj.entity;

import static org.junit.Assert.*;

import org.junit.Test;

public class TimeTest {

	@Test
	public void testAddTimeTime() {
		Time t1 = new Time(4,30);
		Time t2 = new Time(3,45);
		
		Time t3 = Time.add(t1, t2);
		Time t4 = new Time(8,15);
		assertEquals(t3,t4);
	}

	@Test
	public void testAddTime() {
		
	}

}
