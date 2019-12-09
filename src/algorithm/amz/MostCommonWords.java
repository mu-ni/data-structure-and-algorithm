package algorithm.amz;

import java.util.*;

/**
 * Created by muni on 2019/12/9
 */
public class MostCommonWords {
    public static void main(String[] args) {
        String paragraph = "Jack and Jill went to the market to buy bread and cheese. Cheese is Jack’s and Jill’s favorite food.";
        System.out.println(new MostCommonWords().mostCommonWord(paragraph, new String[]{"and", "he", "the", "to", "is", "Jack", "Jill"}));
    }

    // time -> p.length + b.length
    // space -> p[word].length + b.length
    public List<String> mostCommonWord(String paragraph, String[] banned) {
        Set<String> set = new HashSet<>();
        for (String bd : banned) {
            set.add(bd.toLowerCase());
        }
        Map<String, Integer> map = new HashMap<>();
        List<String> rst = new ArrayList<>();
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
            }
            sb = new StringBuilder();
        }

        for (String word : map.keySet()) {
            if (map.get(word) == max) rst.add(word);
        }
        return rst;
    }
}
