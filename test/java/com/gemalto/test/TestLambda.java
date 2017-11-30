package com.gemalto.test;

public class TestLambda {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		new Thread(
				() -> System.out.println("hello world")
			).start();
		

	}

}
