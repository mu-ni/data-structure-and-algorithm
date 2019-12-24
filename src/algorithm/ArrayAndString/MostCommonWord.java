package algorithm.ArrayAndString;

import java.util.*;

public class MostCommonWord {
    public static void main(String[] args) {
        System.out.println(new MostCommonWord().mostCommonWord("Bob hit a ball, the hit BALL flew far after it was hit.", new String[]{"hit"}));
        System.out.println(new MostCommonWord().mostCommonWord2("Bob hit a ball, the hit BALL flew far after it was hit.", new String[]{"hit"}));
    }

    public String mostCommonWord(String paragraph, String[] banned) {
        paragraph += ".";
        Set<String> set = new HashSet<>(Arrays.asList(banned));
        Map<String, Integer> map = new HashMap<>();
        String rst = "";
        int max = 0;

        StringBuilder sb = new StringBuilder();
        for (int i=0; i<paragraph.length(); i++) {
            char c = paragraph.charAt(i);
            if (Character.isLetter(c)) {
                sb.append(c);
                continue;
            }

            String word = sb.toString().toLowerCase();
            if (word.length() > 0 && !set.contains(word)) {
                int count = map.getOrDefault(word, 0) + 1;
                map.put(word, count);
                max = Math.max(max, count);
                if (count == max) rst = word;
            }
            sb = new StringBuilder();
        }
        return rst;
    }

    public String mostCommonWord2(String paragraph, String[] banned) {
        Set<String> set = new HashSet<>(Arrays.asList(banned));
        Map<String, Integer> map = new HashMap<>();
        StringBuilder sb = new StringBuilder();
        String rst = "";
        int maxOccur = 0;
        paragraph += "."; // parse the last word
        for (char c : paragraph.toCharArray()) {
            if (Character.isLetter(c)) {
                sb.append(c);
                continue;
            }
            String word = sb.toString().toLowerCase();
            if (!word.isEmpty() && !set.contains(word)) {
                int count = map.getOrDefault(word, 0) + 1;
                if (count > maxOccur) {
                    rst = word;
                    maxOccur = count;
                }
                map.put(word, count);
            }
            sb = new StringBuilder();
        }
        return rst;
    }
}
