package algorithm.ArrayAndString;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by muni on 2020/1/17
 */
public class ShortestCompletingWord {
    public static void main(String[] args) {
        System.out.println(new ShortestCompletingWord().shortestCompletingWord("1s3 PSt", new String[]{"step", "steps", "stripe", "stepple"}));
        System.out.println(new ShortestCompletingWord().shortestCompletingWord2("1s3 PSt", new String[]{"step", "steps", "stripe", "stepple"}));
    }

    public String shortestCompletingWord(String licensePlate, String[] words) {
        int[] dict = new int[128];
        for (char c : licensePlate.toLowerCase().toCharArray()) {
            if (!Character.isLetter(c)) continue;
            dict[c]++;
        }

        String rst = "";
        for (String word : words) {
            int[] arr = new int[128];
            for (char c : word.toLowerCase().toCharArray()) {
                arr[c]++;
            }
            if (isValid(dict, arr) && (rst.equals("") || word.length() < rst.length())) {
                rst = word;
            }
        }
        return rst;
    }

    private boolean isValid(int[] dir, int[] arr) {
        for (int i=0; i<128; i++) {
            if (dir[i] == 0) continue;
            if (arr[i] < dir[i]) return false;
        }
        return true;
    }

    public String shortestCompletingWord2(String licensePlate, String[] words) {
        Arrays.sort(words, Comparator.comparingInt(String::length));
        int[] dict = new int[128];
        for (char c : licensePlate.toLowerCase().toCharArray()) {
            if (!Character.isLetter(c)) continue;
            dict[c]++;
        }
        for (String word : words) {
            int[] arr = new int[128];
            for (char c : word.toLowerCase().toCharArray()) {
                arr[c]++;
            }
            if (isValid(dict, arr)) return word;
        }
        return "";
    }
}
