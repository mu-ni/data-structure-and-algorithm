package algorithm.TwoPointers;

public class ReplaceForBalancedString {
    public static void main(String[] args) {
        System.out.println(new ReplaceForBalancedString().balancedString("QWER"));
    }

    public int balancedString(String s) {
        int[] arr = new int[128];
        for (char c : s.toCharArray()) {
            arr[c]++;
        }
        int k = s.length()/4;
        int slow = 0;
        int fast = 0;
        int rst = s.length();
        while (fast < s.length()) {
            arr[s.charAt(fast)]--;
            fast++;
            while (slow < s.length() && arr['Q'] <= k && arr['W'] <= k && arr['E'] <= k && arr['R'] <= k) {
                rst = Math.min(rst, fast - slow);
                arr[s.charAt(slow)]++;
                slow++;
            }
        }
        return rst;
    }
}
