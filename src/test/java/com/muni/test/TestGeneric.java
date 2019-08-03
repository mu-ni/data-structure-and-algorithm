package com.muni.test;

public class TestGeneric {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		out("findingsea");
        out(123);
        out(11.11);
        out(true);
	}

	public static <T> void out(T t) {
		System.out.println(t);
	}

}
