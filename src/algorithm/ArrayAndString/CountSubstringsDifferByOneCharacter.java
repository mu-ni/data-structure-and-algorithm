package algorithm.ArrayAndString;

/**
 * Created by muni on 2020/11/3
 */
public class CountSubstringsDifferByOneCharacter {
    public static void main(String[] args) {
        System.out.println(new CountSubstringsDifferByOneCharacter().countSubstrings("ab", "bb"));
        System.out.println(new CountSubstringsDifferByOneCharacter().countSubstrings("aba", "baba"));

        System.out.println(new CountSubstringsDifferByOneCharacter().countSubstrings2("ab", "bb"));
        System.out.println(new CountSubstringsDifferByOneCharacter().countSubstrings2("aba", "baba"));
    }

    public int countSubstrings(String s, String t) {
        int rst = 0;
        for (int i=0; i<s.length(); i++) {
            rst += helper(s, t, i, 0);
        }
        for (int j=1; j<t.length(); j++) {
            rst += helper(s, t, 0, j);
        }
        return rst;
    }

    private int helper(String s, String t, int i, int j) {
        int rst = 0;
        int pre = 0;
        int cur = 0;
        while (i < s.length() && j < t.length()) {
            cur++;
            if (s.charAt(i) != t.charAt(j)) {
                pre = cur;
                cur = 0;
            }
            rst += pre;
            i++;
            j++;
        }
        return rst;
    }

    // brute force
    public int countSubstrings2(String s, String t) {
        int rst = 0;
        for (int i=0; i<s.length(); i++) {
            for (int j=0; j<t.length(); j++) {
                int miss = 0;
                for (int pos = 0; i+pos<s.length() && j+pos<t.length(); pos++) {
                    if (s.charAt(i+pos) != t.charAt(j+pos)) {
                        miss++;
                        if (miss > 1) break;
                    }
                    if (miss == 1) rst++;
                }
            }
        }
        return rst;
    }
}
