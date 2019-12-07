package algorithm.Backtrack;

import java.util.ArrayList;
import java.util.List;

public class CircularPermutation {
    public static void main(String[] args) {
        System.out.println(new CircularPermutation().circularPermutation(3, 2));
        // 2,6,7,5,4,0,1,3
        // 010,110,111,101,100,000,001,011
    }

    int i=0;
    public List<Integer> circularPermutation(int n, int start) {
        List<Integer> rst = new ArrayList<>();
        String binary = Integer.toBinaryString(start);
        binary = padding(binary, n);
        backtrack(rst, binary, 0, n);
        return rst;
    }

    public void backtrack(List<Integer> rst, String binary, int start, int n) {
        System.out.println(binary);
        if (i == Math.pow(2, n)-1) {
            rst.add(Integer.parseInt(binary, 2));
            return;
        }
        rst.add(Integer.parseInt(binary, 2));
        i++;
        for (int j=start; j < n; j++) {
            char[] chars = binary.toCharArray();
//            for (char c = '0'; c <= '1'; c++) {
//                if (chars[j] == c) continue;
//                char tmp = chars[j];
//                chars[j] = c;
//                backtrack(rst, new String(chars), start+1, n);
//                chars[j] = tmp;
//            }
            chars[j] = chars[j] == '0' ? '1' : '0';
            backtrack(rst, new String(chars), start+1, n);
            chars[j] = chars[j] == '0' ? '1' : '0';
        }
    }

    public String padding(String binary, int n) {
        int i = n - binary.length();
        while (i > 0) {
            binary = "0" + binary;
            i--;
        }
        return binary;
    }
}
