package algorithm.TwoPointers;

public class LongestRepeatingCharacterReplacement {
    public static void main(String[] args) {
        System.out.println(new LongestRepeatingCharacterReplacement().characterReplacement("ABAB", 2));
    }

    public int characterReplacement(String s, int k) {
        int[] arr = new int[128];
        int slow = 0;
        int fast = 0;
        int max = 0;
        int count = 0;
        while (fast < s.length()) {
            arr[s.charAt(fast)]++;
            count = Math.max(count, arr[s.charAt(fast)]);
            fast++;
            if (fast - slow > count + k) {
                arr[s.charAt(slow)]--;
                slow++;
            }
            max = Math.max(max, fast - slow);
        }
        return max;
    }
}
