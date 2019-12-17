package algorithm.Graph;

import java.util.*;

public class WordLadder {
    public static void main(String[] args) {
        List<String> wordList = Arrays.asList("hot", "dot", "dog", "lot", "log", "cog");
        System.out.println(new WordLadder().ladderLength("hit", "cog", wordList));
        System.out.println(new WordLadder().ladderLength2("hit", "cog", wordList));
        System.out.println(new WordLadder().ladderLength3("hit", "cog", wordList));
    }

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet = new HashSet<>(wordList);
        Set<String> reached = new HashSet<>();
        reached.add(beginWord);
        wordSet.remove(beginWord);

        int distance = 1;
        while (!reached.isEmpty()) {
            Set<String> newReached = new HashSet<>();
            for (String word : reached) {
                for (int i = 0; i < word.length(); i++) {
                    char[] chars = word.toCharArray();
                    for (char c = 'a'; c <= 'z'; c++) {
                        chars[i] = c;
                        String newWord = new String(chars);
                        if (wordSet.contains(newWord)) {
                            newReached.add(newWord);
                            wordSet.remove(newWord);
                            if (newWord.equals(endWord)) return distance + 1;
                        }
                    }
                }
            }
            distance++;
            reached = newReached;
        }
        return 0;
    }

    // TLE
    int dist = Integer.MAX_VALUE;
    public int ladderLength2(String beginWord, String endWord, List<String> wordList) {
        wordList.remove(beginWord);
        backtrack(beginWord, endWord, new ArrayList<>(wordList), 1);
        return dist == Integer.MAX_VALUE ? 0 : dist;
    }

    public void backtrack(String beginWord, String endWord, List<String> wordList, int step) {
        if (beginWord.equals(endWord)) {
            dist = Math.min(dist, step);
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
                    backtrack(newWord, endWord, wordList, step + 1);
                    wordList.add(newWord);
                }
                arr[i] = tmp;
            }
        }
    }

    // TLE
    public int ladderLength3(String beginWord, String endWord, List<String> wordList) {
        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        Set<String> visited = new HashSet<>();
        visited.add(beginWord);

        int step = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i=0; i<size; i++) {
                String word = queue.poll();
                if (word.equals(endWord)) return step;
                for (int j=0; j<word.length(); j++) {
                    char tmp = word.charAt(j);
                    char[] arr = word.toCharArray();
                    for (char c='a'; c <='z'; c++) {
                        arr[j] = c;
                        String str = new String(arr);
                        if (!wordList.contains(str) || visited.contains(str)) continue;
                        visited.add(str);
                        queue.offer(str);
                        arr[j] = tmp;
                    }
                }
            }
            step++;
        }
        return 0;
    }
}
