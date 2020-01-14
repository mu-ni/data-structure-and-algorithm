package algorithm.SearchAndSort;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Created by muni on 2020/1/14
 */
public class KthSmallestInSortedMatrix {
    public static void main(String[] args) {
        int[][] matrix = new int[][]{{1,5,9},{10,11,13},{12,13,15}};
        System.out.println(new KthSmallestInSortedMatrix().kthSmallest(matrix, 8));
        System.out.println(new KthSmallestInSortedMatrix().kthSmallest2(matrix, 8));
    }

    public int kthSmallest(int[][] matrix, int k) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[] arr = new int[m*n];
        int index = 0;
        for (int i=0; i<m; i++) {
            for (int j=0; j<n; j++) {
                arr[index++] = matrix[i][j];
            }
        }
        Arrays.sort(arr);
        return arr[k-1];
    }

    public int kthSmallest2(int[][] matrix, int k) {
        int m = matrix.length;
        int n = matrix[0].length;
        // max heap
        Queue<Integer> pq = new PriorityQueue<>(k, Collections.reverseOrder());
        for (int i=0; i<m; i++) {
            for (int j=0; j<n; j++) {
                if (pq.size() < k) {
                    pq.offer(matrix[i][j]);
                    continue;
                }
                // pq.size >= k
                if (matrix[i][j] < pq.peek()) {
                    pq.poll();
                    pq.offer(matrix[i][j]);
                }
            }
        }
        return pq.peek();
    }
}
