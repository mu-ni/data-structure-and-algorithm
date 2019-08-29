package algorithm.LinkedList;

import algorithm.LinkedList.Dao.ListNode;

public class ReverseN {
    public static void main(String[] args) {
        System.out.println(reverseN(ListNode.getList(new int[]{1,2,3,4,5,6,7}), 3).toString());
        System.out.println(reverseN(ListNode.getList(new int[]{1,2,3,4,5,6,7}), 0).toString());
        System.out.println(reverseN(ListNode.getList(new int[]{1,2,3,4,5,6,7}), 7).toString());
        System.out.println(reverseN(ListNode.getList(new int[]{1,2,3,4,5,6,7}), 8).toString());
    }

    public static ListNode reverseN(ListNode head, int n) {
        ListNode pre = null;
        ListNode cur = head;
        while (cur != null && n-- > 0) {
            ListNode tmp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = tmp;
        }

        if (n > 0) return new ListNode(-1); //invalid n
        if (pre == null) return cur;
        head.next = cur;
        return pre;
    }
}
