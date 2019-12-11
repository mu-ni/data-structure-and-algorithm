package flag.amz;

import java.util.*;

public class ReorganizeString {
    public static void main(String[] args) {
        System.out.println(new ReorganizeString().reorganizeString("aab"));
    }

    public String reorganizeString(String S) {
        PriorityQueue<int[]> q = new PriorityQueue<>((a, b) -> b[1] - a[1]);
        int[] m = new int[26];
        for(int i = 0; i < S.length(); i++) m[S.charAt(i) - 'a']++; // map of char counts

        for(int i = 0; i < 26; i++) {
            if(m[i] != 0) {
                q.offer(new int[] {i, m[i]}); // add char counts to priority queue
            }
        }

        int[] prev = new int[] {-1,0};
        StringBuilder sb = new StringBuilder();
        while(!q.isEmpty()) {
            int[] cur = q.poll();
            if(prev[1] > 0) q.offer(prev); // add back last used character

            sb.append((char)(cur[0] + 'a')); // append current character
            cur[1]--; // decrease count of current char since it's used
            prev = cur; // set this character as previous used
            if(q.isEmpty() && prev[1] > 0) return ""; // if we left with anything return ""
        }
        return sb.toString();
//        Map<Character, Integer> map = new HashMap<>();
//        for (char c : S.toCharArray()) {
//            int count = map.getOrDefault(c, 0) + 1;
//            // Impossible to form a solution
//            if (count > (S.length() + 1) / 2) return "";
//            map.put(c, count);
//        }
//
//        Queue<int[]> pq = new PriorityQueue<>((a, b) -> b[1] - a[1]);
//        for (char c : map.keySet()) {
//            pq.add(new int[] {c, map.get(c)});
//        }
//        StringBuilder sb = new StringBuilder();
//        while (!pq.isEmpty()) {
//            int[] first = pq.poll();
//            if (sb.length() == 0 || first[0] != sb.charAt(sb.length() - 1)) {
//                sb.append((char) first[0]);
//                if (--first[1] > 0) {
//                    pq.add(first);
//                }
//            } else {
//                int[] second = pq.poll();
//                sb.append((char) second[0]);
//                if (--second[1] > 0) {
//                    pq.add(second);
//                }
//                pq.add(first);
//            }
//        }
//        return sb.toString();
    }
}
