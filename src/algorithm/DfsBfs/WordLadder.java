package algorithm.DfsBfs;

import java.util.*;

public class WordLadder {
    public static void main(String[] args) {
        List<String> wordList = Arrays.asList("hot","dot","dog","lot","log", "cog");
        System.out.println(new WordLadder().ladderLength("hit", "cog", wordList));
    }

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet=new HashSet<>(wordList);
        Set<String> reached = new HashSet<>();
        reached.add(beginWord);
        wordSet.remove(beginWord);

        int distance = 1;
        while (!reached.isEmpty()) {
            Set<String> newReached = new HashSet<>();
            for (String word : reached) {
                for (int i=0; i<word.length(); i++) {
                    char[] chars = word.toCharArray();
                    for (char c = 'a'; c <='z'; c++) {
                        chars[i] = c;
                        String newWord = new String(chars);
                        if (wordSet.contains(newWord)) {
                            newReached.add(newWord);
                            wordSet.remove(newWord);
                            if (newWord.equals(endWord)) return distance+1;
                        }
                    }
                }
            }
            distance++;
            reached = newReached;
        }
        return 0;
    }
}
