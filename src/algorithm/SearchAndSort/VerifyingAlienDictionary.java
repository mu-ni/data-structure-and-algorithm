package algorithm.SearchAndSort;

import java.util.Arrays;
import java.util.Comparator;

public class VerifyingAlienDictionary {
    public static void main(String[] args) {
        System.out.println(new VerifyingAlienDictionary().isAlienSorted(new String[]{"word","world","row"}, "worldabcefghijkmnpqstuvxyz"));
        System.out.println(new VerifyingAlienDictionary().isAlienSorted2(new String[]{"word","world","row"}, "worldabcefghijkmnpqstuvxyz"));
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

    public boolean isAlienSorted2(String[] words, String order) {
        String[] sorted = words.clone();
        Arrays.sort(sorted, (a, b) -> {
            int i1 = 0;
            int i2 = 0;
            while (i1 < a.length() && i2 < b.length()) {
                Integer idx1 = order.indexOf(a.charAt(i1));
                Integer idx2 = order.indexOf(b.charAt(i2));
                if (!idx1.equals(idx2)) return idx1.compareTo(idx2);
                i1++;
                i2++;
            }
            return i1 < a.length() ? 1 : -1;
        });
        return Arrays.equals(words, sorted);
    }
}
