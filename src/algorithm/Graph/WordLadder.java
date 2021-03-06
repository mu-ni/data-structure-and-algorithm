package algorithm.Graph;

import java.util.*;

public class WordLadder {
    public static void main(String[] args) {
        List<String> wordList = Arrays.asList("hot", "dot", "dog", "lot", "log", "cog");
        System.out.println(new WordLadder().ladderLength("hit", "cog", wordList));
        System.out.println(new WordLadder().ladderLength2("hit", "cog", wordList));
        System.out.println(new WordLadder().ladderLength3("hit", "cog", wordList));
        System.out.println(new WordLadder().ladderLength4("hit", "cog", wordList));
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

    public int ladderLength3(String beginWord, String endWord, List<String> wordList) {
        Set<String> dict = new HashSet<>(wordList);
        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        dict.remove(beginWord);

        int step = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i=0; i<size; i++) {
                char[] arr = queue.poll().toCharArray();
                for (int j=0; j<arr.length; j++) {
                    char tmp = arr[j];
                    for (char c='a'; c <='z'; c++) {
                        arr[j] = c;
                        String str = new String(arr);
                        if (!dict.contains(str)) continue;
                        if (str.equals(endWord)) return step+1;
                        queue.offer(str);
                        dict.remove(str);
                    }
                    arr[j] = tmp;
                }
            }
            step++;
        }
        return 0;
    }

    // TLE
    public int ladderLength4(String beginWord, String endWord, List<String> wordList) {
        if (!wordList.contains(endWord) || beginWord.equals(endWord)) return 0;
        Queue<String> queue = new LinkedList<>();
        Set<String> set = new HashSet<>();
        queue.offer(beginWord);
        set.add(beginWord);
        int step = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i=0; i<size; i++) {
                String word = queue.poll();
                System.out.println(word + "-" + step);
                if (word.equals(endWord)) return step;
                char[] arr = word.toCharArray();
                for (int j=0; j<arr.length; j++) {
                    char tmp = arr[j];
                    for (char c = 'a'; c <= 'z'; c++) {
                        arr[j] = c;
                        String next = new String(arr);
                        if (wordList.contains(next) && !set.contains(next)) {
                            queue.offer(next);
                            set.add(next);
                        }
                        arr[j] = tmp;
                    }
                }
            }
            step++;
        }
        return 0;
    }
}
