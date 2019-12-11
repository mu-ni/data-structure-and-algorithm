package flag.amz;

import java.util.*;

/**
 * Created by muni on 2019/12/9
 */
public class TruckSortCenter {
    public static void main(String[] args) {
        int[] packagesSpace = new int[]{1, 10, 25, 35, 60}; // has duplicated??
        System.out.println(Arrays.toString(new TruckSortCenter().sortCenter(90, packagesSpace)));
        packagesSpace = new int[]{1, 10, 25, 30, 30}; // has duplicated??
        System.out.println(Arrays.toString(new TruckSortCenter().sortCenter2(90, packagesSpace)));
    }

    public int[] sortCenter(int truckSpace, int[] packagesSpace) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i=0; i<packagesSpace.length; i++) {
            map.put(packagesSpace[i], i);
        }

        Arrays.sort(packagesSpace);
        int left = 0;
        int right = packagesSpace.length-1;
        int[] rst = new int[2];
        while (left < right) {
            int sum = packagesSpace[left] + packagesSpace[right];
            if (sum > truckSpace - 30) {
                right--;
            } else {
                rst[0] = map.get(packagesSpace[left]);
                rst[1] = map.get(packagesSpace[right]);
                left++;
            }
        }
        return rst;
    }

    public int[] sortCenter2(int truckSpace, int[] packagesSpace) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i=0; i<packagesSpace.length; i++) {
            map.putIfAbsent(packagesSpace[i], new ArrayList<>());
            map.get(packagesSpace[i]).add(i);
        }

        Arrays.sort(packagesSpace);
        int left = 0;
        int right = packagesSpace.length-1;
        int[] rst = new int[2];
        while (left < right) {
            int sum = packagesSpace[left] + packagesSpace[right];
            if (sum > truckSpace - 30) {
                right--;
            } else {
                if (packagesSpace[left] == packagesSpace[right]) {
                    rst[0] = map.get(packagesSpace[left]).get(0);
                    rst[1] = map.get(packagesSpace[right]).get(1);
                } else {
                    rst[0] = map.get(packagesSpace[left]).get(0);
                    rst[1] = map.get(packagesSpace[right]).get(0);
                }
                left++;
            }
        }
        return rst;
    }
}
