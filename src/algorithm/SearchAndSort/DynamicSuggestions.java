package algorithm.SearchAndSort;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class DynamicSuggestions {
    public static void main(String[] args) {
        String[] repo = new String[]{"mobile", "mouse", "moneypot", "monitor", "mousepad"};
        System.out.println(new DynamicSuggestions().dynamicSuggestions(5, repo, "mouse"));
    }

    public List<List<String>> dynamicSuggestions(int num, String[] repo, String query) {
        Arrays.sort(repo);
        boolean[] isInvalid = new boolean[repo.length];
        List<List<String>> rst = new ArrayList<>();
        for (int i=1; i<query.length(); i++) {
            String sub = query.substring(0, i+1).toLowerCase();
            List<String> list = new ArrayList<>();
            for (int j=0; j<repo.length; j++) {
                String word = repo[j];
                if (isInvalid[j] || list.contains(word)) continue;
                if (word.toLowerCase().startsWith(sub)) {
                    list.add(word);
                    if (list.size() == 3) break;
                } else {
                    isInvalid[j] = true;
                }
            }
            rst.add(list);
        }
        return rst;
    }
}
