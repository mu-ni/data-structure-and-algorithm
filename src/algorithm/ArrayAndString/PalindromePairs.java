package algorithm.ArrayAndString;

import java.util.*;

public class PalindromePairs {
    public static void main(String[] args) {
        String[] words = new String[]{"abcd", "dcba", "lls", "s", "sssll"};
        System.out.println(new PalindromePairs().palindromePairs(words));
        System.out.println(new PalindromePairs().palindromePairs2(words));
    }

    // TLE
    public List<List<Integer>> palindromePairs(String[] words) {
        List<List<Integer>> rst = new ArrayList<>();
        for (int i = 0; i < words.length; i++) {
            for (int j = 0; j < words.length; j++) {
                if (i == j) continue;
                String s = words[i] + words[j];
                if (isPalindrome(s)) {
                    rst.add(Arrays.asList(i, j));
                }
            }
        }
        return rst;
    }

    public List<List<Integer>> palindromePairs2(String[] words) {
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < words.length; ++i) {
            map.put(words[i], i);
        }

        Set<List<Integer>> rst = new HashSet<>();
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            for (int j = 0; j <= word.length(); j++) {
                String str1 = word.substring(0, j);
                String str2 = word.substring(j);

                if (isPalindrome(str1)) {
                    String str2rvs = new StringBuilder(str2).reverse().toString();
                    if (map.containsKey(str2rvs) && map.get(str2rvs) != i) {
                        rst.add(Arrays.asList(map.get(str2rvs), i));
                    }
                }

                if (isPalindrome(str2)) {
                    String str1rvs = new StringBuilder(str1).reverse().toString();
                    if (map.containsKey(str1rvs) && map.get(str1rvs) != i) {
                        rst.add(Arrays.asList(i, map.get(str1rvs)));
                    }
                }
            }
        }
        return new ArrayList<>(rst);
    }

    public boolean isPalindrome(String s) {
        StringBuilder sb = new StringBuilder(s);
        return sb.reverse().toString().equals(s);
    }
}
