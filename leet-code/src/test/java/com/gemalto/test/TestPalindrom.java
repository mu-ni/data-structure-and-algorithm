package com.gemalto.test;

public class TestPalindrom {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String test = "abcdcba";
		System.out.println(new TestPalindrom().isPalindrom(test));
	}

	public boolean isPalindrom(String str) {		
		for(int i=0; i<str.length()/2; i++) {
			String first = str.substring(i, i+1);
			String last = str.substring(str.length()-i-1, str.length()-i);
			System.out.println(first + "," + last);
			if(!first.equals(last)) {
				return false;
			}
		}		
		return true;
	}
}
