package algorithm.ArrayAndString;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class LongestWordInDictionary {
    public static void main(String[] args) {
        String[] words = new String[]{"a", "banana", "app", "appl", "ap", "apply", "apple"};
        System.out.println(new LongestWordInDictionary().longestWord(words));
        System.out.println(new LongestWordInDictionary().longestWord2(words));
    }

    public String longestWord(String[] words) {
        Arrays.sort(words);
        Set<String> set = new HashSet<>(Arrays.asList(words));
        String rst = "";
        for (String word : words) {
            boolean exist = true;
            for (int i=0; i<word.length(); i++) {
                String sub = word.substring(0, i+1);
                if (!set.contains(sub)) exist = false;
            }
            if (exist && word.length() > rst.length()) rst = word;
        }
        return rst;
    }

    public String longestWord2(String[] words) {
        Arrays.sort(words);
        Set<String> set = new HashSet<>();
        String rst = "";
        for (String word : words) {
            if (word.length() == 1 || set.contains(word.substring(0, word.length()-1))) {
                rst = word.length() > rst.length() ? word : rst;
                set.add(word);
            }
        }
        return rst;
    }
}
