package algorithm.ArrayAndString;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by muni on 2019/12/11
 */
public class SentenceSimilarity {
    public static void main(String[] args) {
        List<List<String>> pairs = new ArrayList<>();
        pairs.add(Arrays.asList("great", "fine"));
        pairs.add(Arrays.asList("acting","drama"));
        pairs.add(Arrays.asList("skills","talent"));
        System.out.println(new SentenceSimilarity().areSentencesSimilar(new String[]{"great", "acting", "skills"}, new String[]{"fine", "drama", "talent"}, pairs));
    }

    public boolean areSentencesSimilar(String[] words1, String[] words2, List<List<String>> pairs) {
        if (words1.length != words2.length) return false;
        for (int i=0; i<words1.length; i++) {
            String w1 = words1[i];
            String w2 = words2[i];
            if (w1.equals(w2)) {
                continue;
            }
            boolean found = false;
            for (List<String> pair : pairs) {
                if (pair.contains(w1) && pair.contains(w2)) {
                    found = true;
                    break;
                }
            }
            if (!found) return false;
        }
        return true;
    }
}
