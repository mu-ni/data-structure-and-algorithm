package algorithm.ArrayAndString;

/**
 * Created by muni on 2020/10/20
 */
public class MinDominoRotationsForEqualRow {
    public static void main(String[] args) {
//        int[] A = new int[]{1,2,1,1,1,2,2,2};
//        int[] B = new int[]{2,1,2,2,2,2,2,2};
        int[] A = new int[]{2,1,2,4,2,2};
        int[] B = new int[]{5,2,6,2,3,2};
        System.out.println(new MinDominoRotationsForEqualRow().minDominoRotations(A, B));
        System.out.println(new MinDominoRotationsForEqualRow().minDominoRotations2(A, B));
    }

    // ???
    public int minDominoRotations(int[] A, int[] B) {
        int[] countA = new int[7];
        int[] countB = new int[7];
        int[] same = new int[7];
        for (int i=0; i<A.length; i++) {
            countA[A[i]]++;
            countB[B[i]]++;
            if (A[i] == B[i]) same[A[i]]++;
        }
        for (int i=1; i<=6; i++) {
            if (countA[i] + countB[i] - same[i] == A.length) {
                return Math.min(countA[i], countB[i]) - same[i];
                // return A.length - Math.max(countA[i], countB[i]);
            }
        }
        return -1;
    }

    // row[i] must be A[0] or B[0]
    public int minDominoRotations2(int[] A, int[] B) {
        int n = A.length;
        int a = 0;
        int b = 0;
        for (int i = 0; i < n; ++i) {
            if ((A[i] != A[0] && B[i] != A[0])) break;
            if (A[i] != A[0]) a++;
            if (B[i] != A[0]) b++;
            if (i == n - 1) return Math.min(a, b);
        }
        a = 0;
        b = 0;
        for (int i = 0; i < n; ++i) {
            if (A[i] != B[0] && B[i] != B[0]) break;
            if (A[i] != B[0]) a++;
            if (B[i] != B[0]) b++;
            if (i == n - 1) return Math.min(a, b);
        }
        return -1;
    }
}
