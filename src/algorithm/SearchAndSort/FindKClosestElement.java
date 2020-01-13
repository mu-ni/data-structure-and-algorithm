package algorithm.SearchAndSort;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by muni on 2020/1/13
 */
public class FindKClosestElement {
    public static void main(String[] args) {
        System.out.println(new FindKClosestElement().findClosestElements(new int[]{1,2,2,2,5,5,5,8,9,9}, 4, 0));
        System.out.println(new FindKClosestElement().findClosestElements2(new int[]{1,2,2,2,5,5,5,8,9,9}, 4, 0));
        System.out.println(new FindKClosestElement().findClosestElements3(new int[]{1}, 1, 1));
    }

    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        Set<Integer> set = new HashSet<>();
        for (int n : arr) {
            int diff = Math.abs(n - x);
            set.add(diff);
            map.putIfAbsent(diff, new ArrayList<>());
            map.get(diff).add(n);
        }

        List<Integer> list = new ArrayList<>(set);
        Collections.sort(list);
        List<Integer> rst = new ArrayList<>();
        for (int diff : list) {
            List<Integer> values = map.getOrDefault(diff, new ArrayList<>());
            Collections.sort(values);
            if (rst.size() + values.size() < k) {
                rst.addAll(values);
            } else {
                rst.addAll(values.subList(0, k-rst.size()));
            }
        }
        Collections.sort(rst);
        return rst;
    }

    // binary search -> min diff
    public List<Integer> findClosestElements2(int[] arr, int k, int x) {
        int start = 0;
        int end = arr.length-k;
        while (start < end) {
            int mid = start + (end - start)/2;
            if (x - arr[mid] > arr[mid+k]-x) {
                start = mid+1;
            } else {
                end = mid;
            }
        }
        return Arrays.stream(arr, start, start+k).boxed().collect(Collectors.toList());
    }

    public List<Integer> findClosestElements3(int[] arr, int k, int x) {
        int slow = 0;
        int fast = arr.length-1;
        while (fast - slow >= k) {
            if (Math.abs(arr[slow] - x) > Math.abs(arr[fast] - x)) {
                slow++;
            } else {
                fast--;
            }
        }
        return Arrays.stream(arr, slow, fast+1).boxed().collect(Collectors.toList());
    }
}
