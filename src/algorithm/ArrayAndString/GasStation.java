package algorithm.ArrayAndString;

import java.util.ArrayList;
import java.util.List;

public class GasStation {
    public static void main(String[] args) {
        int[] arr = new int[]{1,2,3,4,5,1,6,6};
        System.out.println(gasStation(7,7,arr));
    }

    // n - drive n kms with full petrol
    // k - number of gas station
    // arr - distance between k ~ k-1
    // starting with full petrol
    public static int gasStation(int n, int k, int[] arr) { // not fully tested
        int rst = 0;
        int cur = n; // current petrol
        for (int i=0; i<k; i++) {
            cur -= arr[i];
            if (cur < 0) return -1;
            if (arr[i+1] > cur) {
                cur = n;
                rst++;
            }
        }
        return rst;
    }
}
