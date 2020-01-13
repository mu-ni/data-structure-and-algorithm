package algorithm.SearchAndSort;

import java.util.*;

/**
 * Created by muni on 2020/1/13
 */
public class FindKClosestElement {
    public static void main(String[] args) {
        System.out.println(new FindKClosestElement().findClosestElements(new int[]{1,2,2,2,5,5,5,8,9,9}, 4, 0));
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
}
