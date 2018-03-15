package com.gemalto.test;

import java.util.ArrayList;
import java.util.List;

public class TestAliGuide {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<String> a = new ArrayList<String>();
		a.add("1");
		a.add("2");
		System.out.println(a.toString());
		for (String temp : a) {
			if ("1".equals(temp)) {
				a.remove(temp);
			}
		}
		System.out.println(a.toString());
	}

}
