package algorithm.SearchAndSort;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class DynamicSuggestions {
    public static void main(String[] args) {
        List<String> repo = Arrays.asList("mobile", "mouse", "moneypot", "monitor", "mousepad");
        System.out.println(new DynamicSuggestions().dynamicSuggestions(5, repo, "mouse"));
    }

    public List<List<String>> dynamicSuggestions(int num, List<String> repo, String query) {
        Collections.sort(repo);
        List<List<String>> rst = new ArrayList<>();
        for (int i=1; i<query.length(); i++) {
            String sub = query.substring(0, i+1).toLowerCase();
            List<String> list = new ArrayList<>();
            for (String word : repo) {
                if (list.contains(word)) continue;
                if (word.toLowerCase().startsWith(sub)) {
                    list.add(word);
                }
            }
            repo = list;
            if (list.size() > 3) {
                rst.add(list.subList(0, 3));
            } else {
                rst.add(list);
            }
        }
        return rst;
    }
}
