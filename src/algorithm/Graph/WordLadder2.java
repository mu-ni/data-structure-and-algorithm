package algorithm.Graph;

import java.util.*;
import java.util.stream.Collectors;

public class WordLadder2 {
    public static void main(String[] args) {
        List<String> wordList = Arrays.asList("hot", "dot", "dog", "lot", "log", "cog");
        System.out.println(new WordLadder2().findLadders("hit", "cog", wordList));
    }

    // TLE
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        wordList.remove(beginWord);
        List<String> path = new ArrayList<>();
        path.add(beginWord);
        List<List<String>> rst = new ArrayList<>();
        backtrack(rst, beginWord, endWord, new ArrayList<>(wordList), path);
        if (rst.size() == 0) return rst;
        Collections.sort(rst, Comparator.comparingInt(o -> o.size()));
        int len = rst.get(0).size();
        return rst.stream().filter(o -> o.size() == len).collect(Collectors.toList());
    }

    public void backtrack(List<List<String>> rst, String beginWord, String endWord, List<String> wordList, List<String> path) {
        if (beginWord.equals(endWord)) {
            rst.add(new ArrayList<>(path));
            return;
        }

        char[] arr = beginWord.toCharArray();
        for (int i = 0; i < beginWord.length(); i++) {
            char tmp = arr[i];
            for (char j = 'a'; j <= 'z'; j++) {
                arr[i] = j;
                String newWord = new String(arr);
                if (wordList.contains(newWord)) {
                    wordList.remove(newWord);
                    path.add(newWord);
                    backtrack(rst, newWord, endWord, wordList, path);
                    wordList.add(newWord);
                    path.remove(newWord);
                }
                arr[i] = tmp;
            }
        }
    }
}
