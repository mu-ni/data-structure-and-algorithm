package algorithm.RecursionAndDP;


import java.util.Arrays;
import java.util.List;

public class WordBreak {
    public static void main(String[] args) {
        List<String> dict = Arrays.asList("cats", "dog", "sand", "and", "cat");
        System.out.println(new WordBreak().wordBreak("catsandog", dict));
        System.out.println(new WordBreak().wordBreak2("catsandog", dict));
        System.out.println(new WordBreak().wordBreak3("catsandog", dict));
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

    public boolean wordBreak2(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length()];
        for (int i=0; i<s.length(); i++) {
            for (int j=i; j<s.length(); j++) {
                String sub = s.substring(i, j+1);
                if (wordDict.contains(sub) && (i == 0 || dp[i-1])) {
                    dp[j] = true;
                }
            }
        }
        return dp[s.length()-1];
    }

    // TLE
    boolean found = false;
    public boolean wordBreak3(String s, List<String> wordDict) {
        helper(s, wordDict, 0);
        return found;
    }

    public void helper(String s, List<String> wordDict, int start) {
        if (start == s.length()) {
            found = true;
            return;
        }

        for (int i=start; i<s.length(); i++) {
            String sub = s.substring(start, i+1);
            if (!wordDict.contains(sub)) continue;
            helper(s, wordDict, i+1);
        }
    }
}
