package algorithm.arrayAndString;

public class CheckPermutation {
    public static void main(String[] args) {
        System.out.println(permutation("abc", "cba"));
        System.out.println(permutation("abc", "cbb"));
    }

    public static boolean permutation(String A, String B) {
        if (A.length() != B.length()) return false;

        int[] arr = new int[128];
        for(char a : A.toCharArray()) {
            arr[a]++;
        }
        for(char b : B.toCharArray()) {
            if(arr[b] <=0 ) return false;
            arr[b]--;
        }
        return true;
    }
}
