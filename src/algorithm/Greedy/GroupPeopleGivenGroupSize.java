package algorithm.Greedy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by muni on 2019/12/27
 */
public class GroupPeopleGivenGroupSize {
    public static void main(String[] args) {
        System.out.println(new GroupPeopleGivenGroupSize().groupThePeople(new int[]{3,3,3,3,3,1,3}));
    }

    // arr[i] -> group size
    public List<List<Integer>> groupThePeople(int[] groupSizes) {
        List<List<Integer>> rst = new ArrayList<>();
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i=0; i<groupSizes.length; i++) {
            int size = groupSizes[i];
            map.putIfAbsent(size, new ArrayList<>());
            map.get(size).add(i);
            if (map.get(size).size() == size) {
                rst.add(map.get(size));
                map.put(size, new ArrayList<>());
            }
        }
        return rst;
    }
}
