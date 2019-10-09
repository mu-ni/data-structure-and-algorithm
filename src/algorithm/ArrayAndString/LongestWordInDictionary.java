package algorithm.ArrayAndString;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class LongestWordInDictionary {
    public static void main(String[] args) {
        String[] words = new String[]{"a", "banana", "app", "appl", "ap", "apply", "apple"};
        System.out.println(new LongestWordInDictionary().longestWord(words));
    }

    public String longestWord(String[] words) {
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
