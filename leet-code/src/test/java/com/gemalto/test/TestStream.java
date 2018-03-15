package com.gemalto.test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class TestStream {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		List<User> list = new ArrayList<>();
		list.add(new User("test1", 10));
		list.add(new User("test2", 15));
		list.add(new User("test3", 20));
		list.add(new User("test4", 25));
		list.add(new User("test5", 30));
		list.add(new User("test5", 30));
		list.add(new User("test6", 28));
		
		list.stream()
		.filter(u -> u.getAge() > 20)
		.peek(u -> u.setAge(u.getAge()+1))
		.sorted(Comparator.comparing(User::getAge).reversed())
		.map(User::toString)
//		.map(User::getName)
		.distinct()
		.limit(2)
		.skip(1)
		.forEach(System.out::println);
//		.collect(Collectors.toList());
		
	}

}
