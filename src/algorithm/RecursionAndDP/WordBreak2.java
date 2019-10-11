package algorithm.RecursionAndDP;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class WordBreak2 {
    public static void main(String[] args) {
        List<String> dict = Arrays.asList("cats", "dog", "sand", "and", "cat");
        System.out.println(new WordBreak2().wordBreak("catsanddog", dict));
        System.out.println(new WordBreak2().wordBreak2("catsanddog", dict));
        System.out.println(new WordBreak2().wordBreak3("catsanddog", dict));
    }

    // TLE
    public List<String> wordBreak(String s, List<String> wordDict) {
        List<String> rst = new ArrayList<>();
        backtrack(rst, s, wordDict, 0, new ArrayList<>());
        return rst;
    }

    public void backtrack(List<String> rst, String s, List<String> wordDict, int start, List<String> path) {
        if (start == s.length()) {
            int len = path.stream().mapToInt(String::length).sum();
            if (len == s.length()) {
                rst.add(String.join(" ", path));
            }
            return;
        }

        for (int i=start; i<s.length(); i++) {
            for (int j=i; j<s.length(); j++) {
                String sub = s.substring(i, j+1);
                if (wordDict.contains(sub)) {
                    path.add(sub);
                    backtrack(rst, s, wordDict, j+1, path);
                    path.remove(path.size()-1);
                }
            }
        }
    }

    public List<String> wordBreak2(String s, List<String> wordDict) {
        return dfs(s, wordDict, new HashMap<>());
    }

    public List<String> dfs(String s, List<String> wordDict, HashMap<String, List<String>> map) {
        if (map.containsKey(s)) return map.get(s);

        List<String> list = new ArrayList<>();
        for (String word : wordDict) {
            if (s.startsWith(word)) {
                String next = s.substring(word.length());
                if(next.length()==0) {
                    list.add(word);
                    continue;
                }
                List<String> subList = dfs(next, wordDict, map);
                for (String sub : subList) {
                    list.add(word + " " + sub);
                }
            }
        }
        map.put(s, list);
        return list;
    }

    // TLE
    public List<String> wordBreak3(String s, List<String> wordDict) {
        List<String> rst = new ArrayList<>();
        backtrack2(rst, s, wordDict, 0, new ArrayList<>());
        return rst;
    }

    public void backtrack2(List<String> rst, String s, List<String> wordDict, int start, List<String> path) {
        if (start == s.length()) {
            rst.add(String.join(" ", path));
            return;
        }

        for (int i=start; i<s.length(); i++) {
            String sub = s.substring(start, i+1);
            if (wordDict.contains(sub)) {
                path.add(sub);
                backtrack2(rst, s, wordDict, i+1, path);
                path.remove(path.size()-1);
            }
        }
    }

}
