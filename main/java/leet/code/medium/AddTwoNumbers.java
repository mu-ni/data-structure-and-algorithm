package leet.code.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AddTwoNumbers {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
			List<Integer> l1 = Arrays.asList(6,9,1);
			List<Integer> l2 = Arrays.asList(4,5,6);
			
			System.out.println(addTwoNumbers(l1, l2).toString());
	}
	
	public static List<Integer> addTwoNumbers(List<Integer> l1, List<Integer> l2) {
		
		if(l1.size() != l2.size()){
			return null;
		}
		
		List<Integer> l3 = new ArrayList<Integer>();
		
		int carry = 0;
		
		for(int i=0;i<l1.size();i++){
			l3.add(carry + (l1.get(i)+l2.get(i))%10);
			carry = (l1.get(i)+l2.get(i))/10;
		}
		
		return l3;
    }
}
