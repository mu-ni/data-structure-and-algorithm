package algorithm.ArrayAndString;

import java.util.Arrays;
import java.util.List;

public class MaxLength {
    public static void main(String[] args) {
        System.out.println(new MaxLength().maxLength(Arrays.asList("cusy", "s", "imelfbpuoawkrq", "roxckjm", "vkaxcbespwotzq", "jrnhyslwbifteqox", "fnisjhckr", "ubvpwtzxh", "sgxkqdlw", "hzsngeotfxbcm", "zhrextvndpcmbql", "bdfxez", "rzgnbf", "hbw", "cohurlnjqpefzayig", "xoqgyjsm")));
    }

    public int maxLength(List<String> arr) {
        int max = 0;
        for (int i = 0; i < arr.size(); i++) {
            // keep sub-sequence
            String str = "";
            for (int j = i; j < arr.size(); j++) {
                str += arr.get(j);
                if (isValid(str)) {
                    max = Math.max(max, str.length());
                } else {
                    // remove arr[i] from str
                    str = str.substring(0, str.length() - arr.get(j).length());
                }
            }
        }
        return max;
    }

    public boolean isValid(String s) {
        int[] arr = new int[128];
        for (char c : s.toCharArray()) {
            if (arr[c] != 0) return false;
            arr[c]++;
        }
        return true;
    }
}
