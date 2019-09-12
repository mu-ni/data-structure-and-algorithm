package design;

import java.util.ArrayList;
import java.util.List;

public class TwoSum {
    List<Integer> list = new ArrayList<>();
    public void add(int number) {
        list.add(number);
    }

    /**
     * @param value: An integer
     * @return: Find if there exists any pair of numbers which sum is equal to the value.
     */
    public boolean find(int value) {
        for (int i=0; i<list.size(); i++) {
            int num = list.get(i);
            int target = value - num;
            list.remove(i);
            boolean found = list.contains(target);
            list.add(num);
            if (found) return true;
        }
        return false;
    }

    public static void main(String[] args) {
        TwoSum twoSum = new TwoSum();
        twoSum.add(2);
        twoSum.add(3);
        System.out.println(twoSum.find(4));;
        System.out.println(twoSum.find(5));;
        System.out.println(twoSum.find(6));
        twoSum.add(3);;
        System.out.println(twoSum.find(6));
    }
}
