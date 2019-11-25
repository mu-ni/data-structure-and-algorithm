package algorithm.ArrayAndString;

public class MaxScoreWords {
    public static void main(String[] args) {
        String[] words = new String[]{"dog","cat","dad","good"};
        char[] letters = new char[]{'a','a','c','d','d','d','g','o','o'};
        int[] score = new int[]{1,0,9,5,0,0,3,0,0,0,0,0,0,0,2,0,0,0,0,0,0,0,0,0,0,0};
        System.out.println(new MaxScoreWords().maxScoreWords(words, letters, score));
    }

    public int maxScoreWords(String[] words, char[] letters, int[] score) {
        int[] dict = new int[score.length];
        for (char c : letters) {
            dict[c - 'a']++;
        }
        return backtrack(words, dict, score, 0);
    }

    public int backtrack(String[] words, int[] dict, int[] score, int start) {
        int max = 0;
        for (int i=start; i<words.length; i++) {
            String word = words[i];
            int count = 0;
            boolean isValid = true;
            for (char c : word.toCharArray()) {
                dict[c - 'a']--;
                count += score[c - 'a'];
                if (dict[c - 'a'] < 0) isValid = false;
            }
            if (isValid) {
                count += backtrack(words, dict, score, i+1);
                max = Math.max(max, count);
            }
            for (char c : word.toCharArray()) {
                dict[c - 'a']++;
                count -= score[c - 'a'];
            }
        }
        return max;
    }
}
