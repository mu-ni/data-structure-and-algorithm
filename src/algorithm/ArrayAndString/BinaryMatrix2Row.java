package algorithm.ArrayAndString;

import algorithm.LinkedList.Dao.ListNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class BinaryMatrix2Row {
    public static void main(String[] args) {
        System.out.println(new BinaryMatrix2Row().reconstructMatrix(5, 5, new int[]{2,1,3,0,1,0,1,1,0,1}));
        System.out.println(new BinaryMatrix2Row().reconstructMatrix2(5, 5, new int[]{2,1,3,0,1,0,1,1,0,1}));
        System.out.println(new BinaryMatrix2Row().reconstructMatrix3(5, 5, new int[]{2,1,3,0,1,0,1,1,0,1}));
    }

    public List<List<Integer>> reconstructMatrix(int upper, int lower, int[] colsum) {
        if (upper + lower != Arrays.stream(colsum).sum()) return new ArrayList<>();

        List<List<Integer>> rst = new ArrayList<>();
        rst.add(getLine(upper, colsum));
        rst.add(getLine(lower, colsum));
        return rst;
    }

    public List<Integer> getLine(int val, int[] colsum) {
        List<Integer> line = new ArrayList<>(Collections.nCopies(colsum.length, 0));
        int sum = 0;
        int i = 0;
        while (i < colsum.length) {
            if (colsum[i] != 0) {
                colsum[i]--;
                sum ++;
                line.set(i, line.get(i) + 1);
                if (sum == val) break;
            }
            i++;
            if (i == colsum.length) {
                i = 0;
            }
        }
        return line;
    }

    public List<List<Integer>> reconstructMatrix2(int upper, int lower, int[] colsum) {
        if (upper + lower != Arrays.stream(colsum).sum()) return new ArrayList<>();

        List<List<Integer>> rst = new ArrayList<>();
        rst.add(getLine2(upper, colsum));
        rst.add(getLine2(lower, colsum));
        return rst;
    }

    public List<Integer> getLine2(int val, int[] colsum) {
        List<Integer> line = new ArrayList<>(Collections.nCopies(colsum.length, 0));
        int sum = 0;
        for (int i=0; i < colsum.length; i++) {
            if (colsum[i] == 0) continue;

            if (sum + colsum[i] > val) {
                int add = val - sum;
                line.set(i, add);
                colsum[i] -= add;
                break;
            }
            line.set(i, colsum[i]);
            sum += colsum[i];
            colsum[i] = 0;
            if (sum == val) break;
        }
        return line;
    }

    public List<List<Integer>> reconstructMatrix3(int upper, int lower, int[] colsum) {
        if (upper + lower != Arrays.stream(colsum).sum()) return new ArrayList<>();

        List<Integer> line1 = Arrays.stream(getLine3(upper, colsum)).boxed().collect(Collectors.toList());
        List<Integer> line2 = Arrays.stream(getLine3(lower, colsum)).boxed().collect(Collectors.toList());
        List<List<Integer>> rst = new ArrayList<>();
        rst.add(line1);
        rst.add(line2);
        return rst;
    }

    public int[] getLine3(int val, int[] colsum) {
        int n = colsum.length;
        int[] arr = new int[n];
        int sum = 0;
        for (int j=0; j<n; j++) {
            if (colsum[j] == 0) continue;
            if (sum + colsum[j] < val) {
                arr[j] = colsum[j];
                sum += colsum[j];
                colsum[j] = 0;
            } else {
                arr[j] = val - sum;
                colsum[j] = colsum[j] - arr[j];
                return arr;
            }
        }
        return new int[0];
    }
}
