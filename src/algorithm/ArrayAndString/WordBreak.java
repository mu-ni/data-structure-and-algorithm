package algorithm.ArrayAndString;


import java.util.Arrays;
import java.util.List;

public class WordBreak {
    public static void main(String[] args) {
        List<String> dict = Arrays.asList("cats", "dog", "sand", "and", "cat");
        System.out.println(new WordBreak().wordBreak("catsandog", dict));
    }

//    public boolean wordBreak(String s, List<String> wordDict) { // not pass all cases
//        Trie trie = new Trie();
//        for (String word : wordDict) {
//            trie.insert(word);
//        }
//
//        int start = 0;
//        int end = 0;
//        while (end < s.length()) {
//            String sub = s.substring(start, end+1);
//            String sub2 = s.substring(end+1);
//            if (trie.search(sub)) {
//                if (trie.search(sub2)) {
//                    return true;
//                }
//                start = end+1;
//                continue;
//            }
//
//            end++;
//        }
//        return start == s.length();
//    }

    public boolean wordBreak(String s, List<String> wordDict) {
        int n = s.length();
        boolean[] dp = new boolean[n+1];
        dp[0] = true;
        for (int i=1; i<=n; i++) {
            for (int j=i; j<=n; j++) {
                String sub = s.substring(i-1, j);
                if (dp[i-1] && wordDict.contains(sub)) {
                    dp[j] = true;
                }
            }
        }
        return dp[n];
    }
}
