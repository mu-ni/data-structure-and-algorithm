package algorithm.ArrayAndString;


import java.util.*;

public class WordSquares {
    public static void main(String[] args) {
        String[] words = new String[]{"abat","baba","atan","atal"};
        System.out.println(new WordSquares().wordSquares(words));
        System.out.println(new WordSquares().wordSquares2(words));
    }

    // TLE
    public List<List<String>> wordSquares(String[] words) {
        List<List<String>> rst = new ArrayList<>();
        if (words.length == 0) return rst;
        backtrack(rst, words, new ArrayList<>());
        return rst;
    }

    public void backtrack(List<List<String>> rst, String[] words, List<String> path) {
        if (path.size() == words[0].length()) {
            if (new ValidWordSquare().validWordSquare(path)) {
                rst.add(new ArrayList<>(path));
            }
            return;
        }
        for (int i=0; i<words.length; i++) {
            path.add(words[i]);
            backtrack(rst, words, path);
            path.remove(path.size()-1);
        }
    }

    public List<List<String>> wordSquares2(String[] words) {
        List<List<String>> rst = new ArrayList<>();
        if (words.length == 0) return rst;

        Map<String, Set<String>> map = new HashMap<>();
        for (String word : words) {
            for (int i=0; i<word.length(); i++) {
                String prefix = word.substring(0, i+1);
                map.putIfAbsent(prefix, new HashSet<>());
                map.get(prefix).add(word);
            }
        }

        for (String word : words) {
            List<String> path = new ArrayList<>();
            path.add(word);
            backtrack(rst, map, 1, words[0].length(), path);
        }
        return rst;
    }

    public void backtrack(List<List<String>> rst, Map<String, Set<String>> map, int start, int n, List<String> path) {
        if (start == n) {
            rst.add(new ArrayList<>(path));
            return;
        }

        StringBuilder sb = new StringBuilder();
        for (String word : path) {
            sb.append(word.charAt(start));
        }
        String prefix = sb.toString();
        if (!map.containsKey(prefix)) {
            return;
        }

        for (String next : map.get(prefix)) {
            path.add(next);
            backtrack(rst, map, start+1, n, path);
            path.remove(path.size()-1);
        }
    }
}
