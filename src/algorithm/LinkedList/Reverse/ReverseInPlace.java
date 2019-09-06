package algorithm.LinkedList.Reverse;

import algorithm.LinkedList.Dao.ListNode;

public class ReverseInPlace {
    public static void main(String[] args) {
        System.out.println(reverse(ListNode.getList(new int[]{1,2,3,4,5})).toString());
    }

    public static ListNode reverse(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode tmp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = tmp;
        }
        return pre;
    }
}
