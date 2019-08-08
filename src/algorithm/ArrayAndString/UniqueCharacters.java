package algorithm.ArrayAndString;

import java.util.Arrays;

public class UniqueCharacters {
    public static void main(String[] args) {
        System.out.println(isUnique("abc"));
        System.out.println(isUnique("abc__"));
    }

    public static boolean isUnique(String s) {
        if(s.length() == 1) return true;
        if(s.length() > 128) return false;

        boolean[] arr = new boolean[128];
        for(char c : s.toCharArray()) {
            if(arr[c]) {
                return false;
            }
            arr[c] = true;
        }
        return true;
    }

    public static boolean isUnique2(String s) {
        if(s.length() == 1) return true;
        if(s.length() > 128) return false;

        char[] arr = s.toCharArray();
        Arrays.sort(arr); // O(n ~ nlogn)
        int index = 0;
        while(index < s.length()-1) {
            if(arr[index] == arr[index + 1]) {
                return false;
            }
            index++;
        }
        return true;
    }

    public static boolean isUnique3(String s) {
        if (s.length() == 1) return true;
        if (s.length() > 128) return false;

        for(int i=0; i<s.length()-1; i++) {
            char cur = s.charAt(i);
            for(int j=i+1; j<s.length(); j++) {
                if(cur == s.charAt(j)) return false;
            }
        }
        return true;
    }
}
