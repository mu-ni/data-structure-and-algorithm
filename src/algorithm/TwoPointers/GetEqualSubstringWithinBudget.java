package algorithm.TwoPointers;

public class GetEqualSubstringWithinBudget {
    public static void main(String[] args) {
        System.out.println(new GetEqualSubstringWithinBudget().equalSubstring("abcd", "bcdf", 3));
        System.out.println(new GetEqualSubstringWithinBudget().equalSubstring2("abcd", "bcdf", 3));
    }

    public int equalSubstring(String s, String t, int maxCost) {
        int len = s.length();
        int maxLen = 0;
        int cost = 0;
        int slow = 0;
        int fast = 0;
        while (fast < len) {
            cost += Math.abs(s.charAt(fast) - t.charAt(fast));
            fast++;
            if (cost > maxCost) {
                cost -= Math.abs(s.charAt(slow) - t.charAt(slow));
                slow++;
            }
            // maybe now [fast, slow] is not valid, but not affect the maxLen
            // keep current maxLen as the next sliding window's size
            maxLen = Math.max(maxLen, fast - slow);
        }
        return maxLen;
    }

    public int equalSubstring2(String s, String t, int maxCost) {
        int slow = 0;
        int fast = 0;
        int cost = 0;
        int rst = 0;
        while (fast < s.length()) {
            cost += Math.abs(s.charAt(fast) - t.charAt(fast));
            fast++;
            if (cost <= maxCost) {
                rst = Math.max(rst, fast - slow);
            } else {
                cost -= Math.abs(s.charAt(slow) - t.charAt(slow));
                slow++;
            }
        }
        return rst;
    }
}
