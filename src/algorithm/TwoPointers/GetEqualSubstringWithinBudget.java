package algorithm.TwoPointers;

public class GetEqualSubstringWithinBudget {
    public static void main(String[] args) {
        System.out.println(new GetEqualSubstringWithinBudget().equalSubstring("abcd", "bcdf", 3));
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
            maxLen = Math.max(maxLen, fast - slow);
        }
        return maxLen;
    }
}
