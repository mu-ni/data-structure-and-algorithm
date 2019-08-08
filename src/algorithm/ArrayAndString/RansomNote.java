package algorithm.ArrayAndString;

public class RansomNote {
    public static void main(String[] args) {
        System.out.println(ransomNote("abc", "abcde"));
        System.out.println(ransomNote("abcde", "abc"));
    }

    public static boolean ransomNote(String ransomNote, String magazine) {
        int[] arr = new int[128];
        for(char c : magazine.toCharArray()) {
            arr[c] ++;
        }
        for(char c : ransomNote.toCharArray()) {
            if(arr[c] == 0) {
                return false;
            }
            arr[c] --;
        }
        return true;
    }
}
