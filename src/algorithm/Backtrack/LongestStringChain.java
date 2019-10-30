//package algorithm.Backtrack;
//
//import java.util.Arrays;
//import java.util.Comparator;
//import java.util.HashSet;
//import java.util.Set;
//
//public class LongestStringChain {
//    public static void main(String[] args) {
//        System.out.println(new LongestStringChain().longestStrChain(new String[]{"a","b","ba","bca","bda","bdca"}));
//    }
//
//    public int longestStrChain(String[] words) {
//        Arrays.sort(words, Comparator.comparingInt(String::length));
//        Set<String> set = new HashSet<>(Arrays.asList(words));
//        int max = 0;
//        for (String word : words) {
//            max = Math.max(max, dfs(word, set, 1));
//        }
//        return max;
//    }
//
//    public int dfs(String word, Set<String> set, int len) {
////        if (!set.contains(word)) return len;
//
//        int max = len;
//        for (int i=0; i<word.length(); i++) {
//            for (char c = 'a'; c <= 'z'; c++) {
//                String str = word.substring(0, i) + c + word.substring(i);
//                if (set.contains(str)) {
//                    max = Math.max(max, dfs(str, set, len+1));
//                }
//            }
//        }
//        return max;
//    }
//}
