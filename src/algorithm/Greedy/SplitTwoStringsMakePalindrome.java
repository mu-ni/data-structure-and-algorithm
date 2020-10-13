package algorithm.Greedy;

/**
 * Created by muni on 2020/10/13
 */
public class SplitTwoStringsMakePalindrome {
    public static void main(String[] args) {
        System.out.println(new SplitTwoStringsMakePalindrome().checkPalindromeFormation("abdef", "fecab"));
        System.out.println(new SplitTwoStringsMakePalindrome().checkPalindromeFormation("acdef", "abcba"));
    }

    public boolean checkPalindromeFormation(String a, String b) {
        return check(a, b) || check(b, a);
    }

    private boolean isPalindrome(String s, int i, int j) {
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) return false;
            i++;
            j--;
        }
        return true;
    }

    private boolean check(String a, String b) {
        int i = 0;
        int j = a.length()-1;
        while (i < j) {
            if (a.charAt(i) != b.charAt(j)) {
                return isPalindrome(a, i, j) || isPalindrome(b, i, j);
            }
            i++;
            j--;
        }
        return true;
    }
}
