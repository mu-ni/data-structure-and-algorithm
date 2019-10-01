package algorithm.ArrayAndString;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class RepeatedDNASequences {
    public static void main(String[] args) {
        System.out.println(new RepeatedDNASequences().findRepeatedDnaSequences("AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"));
        System.out.println(new RepeatedDNASequences().findRepeatedDnaSequences2("AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"));
    }

    // find all the 10-letter-long repeated sequences
    // TLE
    public List<String> findRepeatedDnaSequences(String s) {
        Set<String> rst = new HashSet<>();
        for (int i = 0; i <= s.length() - 10; i++) {
            String sub = s.substring(i, i + 10);
            String rem1 = s.substring(0, i + 9);
            String rem2 = s.substring(i + 1);
            if (rem1.contains(sub) || rem2.contains(sub)) {
                rst.add(sub);
            }
        }
        return new ArrayList<>(rst);
    }

    public List<String> findRepeatedDnaSequences2(String s) {
        Set<String> set1 = new HashSet<>();
        Set<String> set2 = new HashSet<>();
        for (int i = 0; i <= s.length() - 10; i++) {
            String sub = s.substring(i, i + 10);
            if (set1.contains(sub)) {
                set2.add(sub);
            }
            set1.add(sub);
        }
        return new ArrayList<>(set2);
    }
}
