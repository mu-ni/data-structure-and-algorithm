package algorithm.ArrayAndString;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class QueryString {
    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();
        map.put("a", 1);
        map.put("abc", 10);
        map.put("bcd", 11);
        map.put("cde", 30);
        map.put("e", 3);
        map.put("fg", 5);
        System.out.println(new QueryString().queryString(map, "abcdefg"));
        System.out.println(new QueryString().queryString(map, "a"));
        System.out.println(new QueryString().queryString(map, "b"));
    }

    public int queryString(Map<String, Integer> dict, String str) {
        if (str.length() <= 1) return dict.getOrDefault(str, -1);

        int[] dp = new int[str.length()];
        for (int j=0; j < str.length(); j++) {
            String s = str.substring(0, j+1);
            dp[j] = helper(s, dict, dp);
        }

        return dp[str.length()-1];
    }

    public int helper(String s, Map<String, Integer> dict, int[] dp) {
        int max = -1;
        if (dict.containsKey(s)) {
            max = dict.get(s);
        }
        for (int i=1; i<s.length(); i++) {
            String s1 = s.substring(0, i);
            String s2 = s.substring(i, s.length());
            if (dict.containsKey(s1) && dict.containsKey(s2)) {
                max = Math.max(max, dict.get(s1) + dict.get(s2));
            }
            if (dp[i-1]!= -1 && dict.containsKey(s2)) {
                max = Math.max(max, dp[i-1] + dict.get(s2));
            }
        }
        return max;
    }
}
