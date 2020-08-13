package design;


import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Created by muni on 2020/8/13
 */
class CombinationIterator {
    Queue<String> pq;

    public CombinationIterator(String characters, int combinationLength) {
        pq = new PriorityQueue();
        backtrack(characters, 0, combinationLength, new StringBuilder());
    }

    public String next() {
        return pq.poll();
    }

    public boolean hasNext() {
        return !pq.isEmpty();
    }

    private void backtrack(String s, int start, int len, StringBuilder sb) {
        if (len == 0) {
            pq.offer(sb.toString());
            return;
        }
        for (int i=start; i<s.length(); i++) {
            sb.append(s.charAt(i));
            backtrack(s, i+1, len-1, sb);
            sb.deleteCharAt(sb.length()-1);
        }
    }

    public static void main(String[] args) {
        CombinationIterator ci = new CombinationIterator("abc", 2);
        // ab, ac, bc
        System.out.println(ci.next());
        System.out.println(ci.hasNext());
        System.out.println(ci.next());
        System.out.println(ci.hasNext());
        System.out.println(ci.next());
        System.out.println(ci.hasNext());
    }
}

/**
 * Your CombinationIterator object will be instantiated and called as such:
 * CombinationIterator obj = new CombinationIterator(characters, combinationLength);
 * String param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */