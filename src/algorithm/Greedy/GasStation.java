package algorithm.Greedy;

public class GasStation {
    public static void main(String[] args) {
        int[] arr = new int[]{1,2,3,4,5,1,6,6};
        System.out.println(gasStation(7,7,arr));
        System.out.println(canCompleteCircuit(new int[]{1,2,3,4,5}, new int[]{3,4,5,1,2}));

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

    // leetcode 134
    public static int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;
        for(int i=0; i<n; i++) {
            int rem = gas[i];
            int j=i;
            while (rem >= cost[j]) {
                rem = rem - cost[j] + gas[(j+1)%n];
                j = (j+1)%n;
                if (i == j) return i;
            }
        }
        return -1;
    }
}
