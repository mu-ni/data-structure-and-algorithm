package algorithm.TwoPointers;

public class ReplaceForBalancedString {
    public static void main(String[] args) {
        System.out.println(new ReplaceForBalancedString().balancedString("WWEQERQWQWWRWWERQWEQ"));
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
        while (slow < s.length() && fast < s.length()) {
            arr[s.charAt(fast)]--;
            fast++;
            while (arr['Q'] <= k && arr['W'] <= k && arr['E'] <= k && arr['R'] <= k) {
                rst = Math.min(rst, fast - slow);
                arr[s.charAt(slow)]++;
                slow++;
            }
        }
        return rst;
    }

//    // WRONG -> minimum length of [substring] -> substring, not character
//    public int balancedString2(String s) {
//        int count = s.length()/4;
//        int[] arr = new int[4];
//        for (char c : s.toCharArray()) {
//            if (c == 'Q') {
//                arr[0]++;
//            } else if (c == 'W') {
//                arr[1]++;
//            } else if (c == 'E') {
//                arr[2]++;
//            } else {
//                arr[3]++;
//            }
//        }
//
//        int rst = 0;
//        for (int n : arr) {
//            rst += Math.abs(count - n);
//        }
//        return rst/2;
//    }
}
