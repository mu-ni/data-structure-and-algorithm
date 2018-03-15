package com.gemalto.test;

public class TestNParse {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		char[] array = str.toCharArray();
		new TestNParse().nParse(array, 4);
	}

	public void nParse(char[] array, int n) {
		String[] rstArray = new String[n];
		for(int i=0; i<n; i++) {
			rstArray[i] = "";
		}
		
		int line = 0;
		int direction = 1;
		for(int i=0; i<array.length; i++) {
			rstArray[line] += array[i];		
			if(line == n-1) {
				direction = -1;
			}
			if(line == 0) {
				direction = 1;
			}	
			line += direction;
		}

		for(String s : rstArray) {
			System.out.println(s);
		}
	}
}
