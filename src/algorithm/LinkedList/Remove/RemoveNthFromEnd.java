package algorithm.LinkedList.Remove;

import algorithm.LinkedList.Dao.ListNode;

public class RemoveNthFromEnd {
    public static void main(String[] args) {
        ListNode head = ListNode.getList(new int[]{1,2,3,4,5});
        System.out.println(removeNthFromEnd(head, 2).toString());

        head = ListNode.getList(new int[]{1,2});
        System.out.println(removeNthFromEnd(head, 2).toString());

        head = ListNode.getList(new int[]{1});
        System.out.println(removeNthFromEnd(head, 1));
    }

    // Given n will always be valid.
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode cur = head;
        ListNode nth = head;

        for(int i=0; i<=n; i++) {
            if(nth == null) {//n == length, remove first
                return head.next;
            }
            nth = nth.next;
        }

        while (nth != null) {
            cur = cur.next;
            nth = nth.next;
        }

        cur.next = cur.next.next;
        return head;
    }
}
