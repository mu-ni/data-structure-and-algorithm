package algorithm.ArrayAndString;

import java.util.Arrays;
import java.util.Comparator;

public class VerifyingAlienDictionary {
    public static void main(String[] args) {
        System.out.println(new VerifyingAlienDictionary().isAlienSorted(new String[]{"word","world","row"}, "worldabcefghijkmnpqstuvxyz"));
    }

    public boolean isAlienSorted(String[] words, String order) {
        Comparator<String> comparator = (o1, o2) -> {
            int i = 0;
            while (i < o1.length() && i < o2.length()) {
                if (o1.charAt(i) != o2.charAt(i)) {
                    return order.indexOf(o1.charAt(i)) - order.indexOf(o2.charAt(i));
                }
                i++;
            }
            return i < o1.length() ? 1 : -1;
        };
        String[] sorted = words.clone();
        Arrays.sort(sorted, comparator);
        return Arrays.equals(words, sorted);
    }
}
