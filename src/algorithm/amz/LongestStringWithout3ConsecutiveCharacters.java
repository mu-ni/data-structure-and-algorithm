package algorithm.amz;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * Created by muni on 2019/12/9
 */
public class LongestStringWithout3ConsecutiveCharacters {
    public static void main(String[] args) {
        Map<Character, Integer> map = new HashMap<>();
        map.put('a',1);
        map.put('b',1);
        map.put('c',6);
        System.out.println(new LongestStringWithout3ConsecutiveCharacters().generateString(map));
    }

    public String generateString(Map<Character, Integer> map) {
        PriorityQueue<Map.Entry<Character, Integer>> pq = new PriorityQueue<>(Map.Entry.<Character, Integer>comparingByValue().reversed());
        for (Map.Entry<Character, Integer> e : map.entrySet()) pq.add(e);
        StringBuilder sb = new StringBuilder();
        char pre = ' ';
        while (!pq.isEmpty()){
            Map.Entry<Character, Integer> e = pq.remove();
            if (e.getKey() != pre){
                append(sb, e, pq);
                pre = e.getKey();
            } else {
                Map.Entry<Character, Integer> e2 = pq.remove();
                append(sb, e2, pq);
                pre = e2.getKey();
                pq.add(e);
            }
        }
        return sb.toString();
    }

    private void append(StringBuilder sb, Map.Entry<Character, Integer> e, PriorityQueue<Map.Entry<Character, Integer>> pq){
        int cnt = e.getValue();
        if (cnt > 1){
            sb.append(e.getKey()).append(e.getKey());
            cnt -= 2;
        } else {
            sb.append(e.getKey());
            cnt--;
        }
        if (cnt > 0) {
            e.setValue(cnt);
            pq.add(e);
        }
    }
}
