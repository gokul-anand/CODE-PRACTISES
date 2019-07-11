package com.visa.prj.client;

import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;

public class ReferenceExample {

	public static void main(String[] args) {
//		WeakReference<String > wr = new WeakReference<String> (new String("Hello"));
		SoftReference<String > wr = new SoftReference<String> (new String("Hello"));
		
		System.out.println(wr.get());
		
		System.gc();
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println(wr.get());
	}

}
