package algorithm.ArrayAndString;


import java.util.Arrays;
import java.util.List;

public class WordBreak {
    public static void main(String[] args) {
        List<String> dict = Arrays.asList("aaaa","aaa");
        System.out.println(new WordBreak().wordBreak("aaaaaaa", dict));
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
        boolean[] dp = new boolean[s.length()+1];
        dp[0] = true;
        for (int i=1; i<=s.length(); i++) {
            for (int j=0; j < i; j++) {
                String sub = s.substring(j, i);
                if (dp[j] && wordDict.contains(sub)) {
                    dp[i] = true;
                }
            }
        }
        return dp[s.length()];
    }
}
