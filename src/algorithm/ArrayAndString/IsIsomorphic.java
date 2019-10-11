package algorithm.ArrayAndString;

import java.util.HashMap;
import java.util.Map;

public class IsIsomorphic {
    public static void main(String[] args) {
        System.out.println(new IsIsomorphic().isIsomorphic("foo", "bar"));
        System.out.println(new IsIsomorphic().isIsomorphic2("foo", "bar"));
    }

    public boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) return false;

        Map<Character, Integer> map1 = new HashMap<>();
        Map<Character, Integer> map2 = new HashMap<>();
        for (Integer i=0; i<s.length(); i++) {
            Object prevS = map1.put(s.charAt(i), i);
            Object prevN = map2.put(t.charAt(i), i);
            if (prevS != prevN) return false;
        }
        return true;
    }

    public boolean isIsomorphic2(String s, String t) {
        if (s.length() != t.length()) return false;
        Map<Character, Integer> map1 = new HashMap<>();
        Map<Character, Integer> map2 = new HashMap<>();
        for (int i=0; i<s.length(); i++) {
            int i1 = map1.getOrDefault(s.charAt(i), -1);
            int i2 = map2.getOrDefault(t.charAt(i), -1);
            if (i1 != i2) return false;
            map1.put(s.charAt(i), i);
            map2.put(t.charAt(i), i);
        }
        return true;
    }

}
