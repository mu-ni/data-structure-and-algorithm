package algorithm.TwoPointers;

public class LongestRepeatingCharacterReplacement {
    public static void main(String[] args) {
        System.out.println(new LongestRepeatingCharacterReplacement().characterReplacement("AABABBA", 1));
        System.out.println(new LongestRepeatingCharacterReplacement().characterReplacement2("AABABBA", 1));
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

    public int characterReplacement2(String s, int k) {
        int[] arr = new int[128];
        int slow = 0;
        int max = 0;
        int count = 0;
        for (int fast = 0; fast < s.length(); fast++) {
            arr[s.charAt(fast)]++;
            count = Math.max(count, arr[s.charAt(fast)]);
            if (fast - slow + 1 > count + k) {
                arr[s.charAt(slow)]--;
                slow++;
            }
            max = Math.max(max, fast-slow+1);
        }
        return max;
    }
}
