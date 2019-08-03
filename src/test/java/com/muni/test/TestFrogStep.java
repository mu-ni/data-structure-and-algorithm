package com.muni.test;

public class TestFrogStep {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(frogStep(5));
	}
	
	private static int frogStep(int step) {
		if(step <= 0) {
			return 0;
		}
		if(step == 1) {
			return 1;
		}
		if(step == 2) {
			return 2;
		}
		return frogStep(step-1) + frogStep(step-2);
	}

}
