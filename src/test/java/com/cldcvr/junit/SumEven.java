package com.cldcvr.junit;

public class SumEven {

	public static void main(String[] args) {

		int a = 12244556, sum = 0;
		while (a >= 1) {
			int num = a % 10;
			if ((num % 2) == 0) {
				sum = sum + num;
			}
			a = a / 10;
		}
		System.out.println(sum);
	}

}
