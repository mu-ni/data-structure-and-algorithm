package algorithm.ArrayAndString.TwoPointers;

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
        int count = 0; // max appearance of any char
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
        int fast = 0;
        int max = 0;
        while (fast < s.length()) {
            arr[s.charAt(fast)]++;
            fast++;
            if (countDiff(arr) > k) {
                arr[s.charAt(slow)]--;
                slow++;
            }
            max = Math.max(max, fast - slow);
        }
        return max;
    }

    // count number of char which is different from the "most frequent character"
    public int countDiff(int[] arr) {
        int sum = 0;
        int max = 0;
        for (int i : arr) {
            sum += i;
            max = Math.max(max, i);
        }
        return sum - max;
    }
}
