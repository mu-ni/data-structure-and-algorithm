package algorithm.TwoPointers;

/**
 * Created by muni on 2020/11/16
 */
public class LongestMountainInArray {
    public static void main(String[] args) {
        System.out.println(new LongestMountainInArray().longestMountain(new int[]{2,1,4,7,3,2,5}));
        System.out.println(new LongestMountainInArray().longestMountain2(new int[]{2,1,4,7,3,2,5}));
    }

    public int longestMountain(int[] A) {
        int max = 0;
        int i = 1;
        while (i < A.length) {
            int increasing = 0;
            while (i < A.length && A[i] > A[i-1]) {
                i++;
                increasing++;
            }
            int decreasing = 0;
            while (i < A.length && A[i] < A[i-1]) {
                i++;
                decreasing++;
            }
            if (increasing > 0 && decreasing > 0) max = Math.max(max, increasing + decreasing + 1);
            while (i < A.length && A[i] == A[i-1]) i++;
        }
        return max;
    }

    //brute force
    public int longestMountain2(int[] A) {
        int max = 0;
        for (int i=0; i<A.length; i++) {
            max = Math.max(max, expand(A, i));
        }
        return max;
    }

    private int expand(int[] A, int mid) {
        int size = 1;
        boolean isLeft = false;
        for (int i=mid-1; i>=0; i--) {
            if (A[i] >= A[i+1]) break;
            isLeft = true;
            size++;
        }
        boolean isRight = false;
        for (int i=mid+1; i<A.length; i++) {
            if (A[i] >= A[i-1]) break;
            isRight = true;
            size++;
        }
        return isLeft && isRight ? size : 0;
    }
}
