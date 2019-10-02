package algorithm.ArrayAndString;

import java.util.HashMap;
import java.util.Map;

public class IsIsomorphic {
    public static void main(String[] args) {
        System.out.println(new IsIsomorphic().isIsomorphic("foo", "bar"));
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
}
