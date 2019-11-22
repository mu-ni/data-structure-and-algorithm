package algorithm.ArrayAndString;

public class MaxScoreWords {
    public static void main(String[] args) {
        String[] words = new String[]{"dog","cat","dad","good"};
        char[] letters = new char[]{'a','a','c','d','d','d','g','o','o'};
        int[] score = new int[]{1,0,9,5,0,0,3,0,0,0,0,0,0,0,2,0,0,0,0,0,0,0,0,0,0,0};
        System.out.println(new MaxScoreWords().maxScoreWords(words, letters, score));
    }

    // WRONG
    public int maxScoreWords(String[] words, char[] letters, int[] score) {
        int max = 0;
        for (String word : words) {
            int count = 0;
            char[] dict = letters.clone();
            for (char c : word.toCharArray()) {
                if (!isValid(dict, c)) {
                    count = 0;
                    break;
                }
                count += score[c - 'a'];
            }
            System.out.println(count);
            max = Math.max(max, count);
        }
        return max;
    }


    public boolean isValid (char[] dict, char c) {
        for (int i=0; i<dict.length; i++) {
            if (dict[i] != c) continue;
            dict[i] = '*';
            return true;
        }
        return false;
    }
}
