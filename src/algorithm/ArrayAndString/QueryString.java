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
        System.out.println(new QueryString().queryString(map, "abcedfg"));
    }

    public int queryString(Map<String, Integer> dict, String str) {
        int[][] dp = new int[dict.size()][str.length()];
        String[] keys = (String[]) dict.keySet().toArray();
        Arrays.sort(keys);
        for (int i=0; i<keys.length; i++) {
            String key = keys[i];
            String s = "";
        }

        return dp[dict.size()-1][str.length()-1];
    }
}
