package test;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;

public class TestOptional {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		User user = (User) Optional
		        .ofNullable(new User("test", 10))
		        .orElse(new User("Unknown", 0));
		        
		System.out.println("Username is: " + user.getName());
		
		Map<String, String> map = new HashMap<>();
		map.put("1", "value1");
        map.put("2", "value2");
        map.put("3", "value3");
        map.put("4", "value4");
        
		for(Entry<String, String> set : map.entrySet()) {
			System.out.println(set.getKey() + ":" + set.getValue());
		}
		
	}

}
