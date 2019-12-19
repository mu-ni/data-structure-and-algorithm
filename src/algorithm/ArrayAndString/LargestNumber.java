package algorithm.ArrayAndString;


import java.util.Arrays;
import java.util.Comparator;

public class LargestNumber {
    public static void main(String[] args) {
        System.out.println(new LargestNumber().largestNumber(new int[]{3,30,34,5,9}));
        System.out.println(new LargestNumber().largestNumber2(new int[]{3,30,34,5,9}));
        System.out.println(new LargestNumber().largestNumber3(new int[]{3,30,34,5,9}));
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

    // [999999998,999999997,999999999] Integer overflow
    public String largestNumber2(int[] nums) {
        Comparator<Integer> comp = (o1, o2) -> {
            Integer n1 = Integer.valueOf(String.valueOf(o1) + o2);
            Integer n2 = Integer.valueOf(String.valueOf(o2) + o1);
            return n2.compareTo(n1);
        };
        Integer[] array = Arrays.stream(nums).boxed().toArray(Integer[]::new);
        Arrays.sort(array, comp);

        StringBuilder sb = new StringBuilder();
        for (Integer i : array) {
            if (sb.length() == 0 && i.equals(0)) continue;
            sb.append(i);
        }
        return sb.length() == 0 ? "0" : sb.toString();
    }

    public String largestNumber3(int[] nums) {
        Comparator<Integer> comp = (a, b) -> {
            Long n1 = Long.valueOf(String.valueOf(a) + String.valueOf(b));
            Long n2 = Long.valueOf(String.valueOf(b) + String.valueOf(a));
            return n2.compareTo(n1);
        };
        Integer[] arr = Arrays.stream(nums).boxed().toArray(Integer[]::new);
        Arrays.sort(arr, comp);
        StringBuilder sb = new StringBuilder();
        for (int n : arr) {
            if (sb.length() == 0 && n == 0) continue;
            sb.append(n);
        }

        return sb.length() == 0 ? "0" : sb.toString();
    }
}
