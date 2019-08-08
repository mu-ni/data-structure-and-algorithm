package algorithm.ArrayAndString;

public class PalindromePermutation {
    public static void main(String[] args) {
        System.out.println(permutePalindrome("code"));
        System.out.println(permutePalindrome("aab"));
    }

    public static boolean permutePalindrome(String s) {
        int[] arr = new int[128];
        for(char c : s.toCharArray()) {
            arr[c]++;
        }

        boolean hasUnique = false;
        for(int i : arr) {
            if(i % 2 == 0) {
                continue;
            }
            if(hasUnique == false && i % 2 == 1) {
                hasUnique = true;
                continue;
            }
            return false;
        }
        return true;
    }
}
