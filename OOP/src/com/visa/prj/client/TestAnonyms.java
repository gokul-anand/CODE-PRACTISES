package com.visa.prj.client;

@FunctionalInterface
interface Computation {
	int compute(int x, int y);
}

public class TestAnonyms {

	public static void main(String[] args) {

		Computation c = new Computation() {
			@Override
			public int compute(int x, int y) {
				return x + y;
			}
		};

		System.out.println(c.compute(3, 4));

		Computation c2 = (int x, int y) -> {
			return x + y;
		};

		System.out.println(c2.compute(3, 4));

		Computation c3 = (x, y) -> x + y;

		System.out.println(c3.compute(3, 4));
		
		
		

	}

}
