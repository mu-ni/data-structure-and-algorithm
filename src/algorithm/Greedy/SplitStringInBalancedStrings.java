package algorithm.Greedy;

/**
 * Created by muni on 2019/12/26
 */
public class SplitStringInBalancedStrings {
    public static void main(String[] args) {
        System.out.println(new SplitStringInBalancedStrings().balancedStringSplit("RLRRLLRLRL"));
        System.out.println(new SplitStringInBalancedStrings().balancedStringSplit2("RLRRLLRLRL"));
    }

    public int balancedStringSplit(String s) {
        int count = 0;
        int flag = 0;
        for (char c : s.toCharArray()) {
            if (c == 'L') {
                flag++;
            } else {
                flag--;
            }
            if (flag == 0) count++;
        }
        return count;
    }

    public int balancedStringSplit2(String s) {
        int count = 0;
        int lCount = 0;
        int rCount = 0;
        for (char c : s.toCharArray()) {
            if (c == 'L') {
                lCount++;
            } else {
                rCount++;
            }
            if (lCount == rCount) {
                count++;
            }
        }
        return count;
    }
}
