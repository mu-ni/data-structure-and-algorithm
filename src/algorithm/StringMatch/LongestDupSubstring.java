package algorithm.StringMatch;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by muni on 2020/6/29
 */
public class LongestDupSubstring {

    public static void main(String[] args) {
        System.out.println(new LongestDupSubstring().longestDupSubstring("banana"));
    }

    public String longestDupSubstring(String S) {
        String rst = "";
        int start = 0;
        int end = S.length()-1;
        while (start <= end) {
            int mid = start + (end - start)/2;
            String dup = dupSubstring(S, mid);
            if (!dup.equals("")) {
                start = mid + 1;
                rst = dup;
            } else {
                end = mid - 1;
            }
        }
        return rst;
    }

    private String dupSubstring(String S, int m) {
        int R = 31;
        Map<Long, List<Integer>> map = new HashMap<>();

        long hash = hash(S, m, R);
        map.putIfAbsent(hash, new ArrayList<>());
        map.get(hash).add(0);

        long RM = 1;
        for (int i=1; i<m; i++) {
            RM *= R;
        }

        for (int i=m; i<S.length(); i++) {
            hash = hash - RM*S.charAt(i - m);
            hash = hash*R + S.charAt(i);
            for (int index : map.getOrDefault(hash, new ArrayList<>())) {
                String s1 = S.substring(index, index+m);
                String s2 = S.substring(i-m+1, i+1);
                if (s1.equals(s2)) return s1;
            }
            map.putIfAbsent(hash, new ArrayList<>());
            map.get(hash).add(i-m+1);
        }

        return "";
    }

    private long hash(String S, int m, int R) {
        long hash = 0;
        for (int i=0; i<m; i++) {
            hash = hash*R + S.charAt(i);
        }
        return hash;
    }
}
