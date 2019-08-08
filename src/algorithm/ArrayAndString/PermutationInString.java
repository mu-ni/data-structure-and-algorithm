package algorithm.ArrayAndString;

import java.util.Arrays;

public class PermutationInString {
    public static void main(String[] args) {
        System.out.println(checkInclusion("ab", "eidbaooo"));
        System.out.println(checkInclusion("abc", "eidbaooo"));
    }

    public static boolean checkInclusion(String s1, String s2) {
        if(s1.length() > s2.length()) return false;

        char[] a1 = s1.toCharArray();
        Arrays.sort(a1);
        for(int i=0; i<=s2.length() - s1.length(); i++) {
            char[] a2 = s2.substring(i, i+s1.length()).toCharArray();
            Arrays.sort(a2);
            if(Arrays.equals(a1, a2)) {
                return true;
            }
        }
        return false;
    }

    public static boolean checkInclusion2(String s1, String s2) {
        if(s1.length() > s2.length()) return false;

        for(int i=0; i<=s2.length() - s1.length(); i++) {
            boolean isPermutation = isPermutation(s1, s2.substring(i, i+s1.length()));
            if(isPermutation) return true;
        }
        return false;
    }

    public static boolean isPermutation(String a, String b) {
        int[] arr = new int[128];
        for(char c : a.toCharArray()) {
            arr[c] ++;
        }
        for(char c : b.toCharArray()) {
            if(arr[c] <= 0) return false;
            arr[c] --;
        }
        return true;
    }

    public static boolean checkInclusion3(String s1, String s2) {
        if(s1.length() > s2.length()) return false;

        int[] arr = new int[128];
        for(int i=0; i< s1.length(); i++) {
            arr[s1.charAt(i)]++;
            arr[s2.charAt(i)]--;
        }
        if(isEmpty(arr)) return true;

        for(int i=s1.length(); i<s2.length(); i++) {
            arr[s2.charAt(i)] --; // reduce difference
            arr[s2.charAt(i-s1.length())] ++;
            if(isEmpty(arr)) return true;
        }
        return false;
    }

    public static boolean isEmpty(int[] arr) {
        for(int i : arr) {
            if(i != 0) return false;
        }
        return true;
    }
}
