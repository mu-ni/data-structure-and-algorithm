package algorithm.ArrayAndString;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class LargestNumber {
    public static void main(String[] args) {
        System.out.println(new LargestNumber().largestNumber(new int[]{3,30,34,5,9}));
    }

    public String largestNumber(int[] nums) {
        Comparator<String> comp = (o1, o2) -> {
            String s1 = o1 + o2;
            String s2 = o2 + o1;
            return s2.compareTo(s1);
        };
        String[] arr = Arrays.stream(nums).mapToObj(String::valueOf).toArray(String[]::new);
        Arrays.sort(arr, comp);

        StringBuilder sb = new StringBuilder();
        for (String s : arr) {
            if (sb.length() == 0 && s.equals("0")) continue;
            sb.append(s);
        }
        return sb.length() == 0 ? "0" : sb.toString();
    }
}
