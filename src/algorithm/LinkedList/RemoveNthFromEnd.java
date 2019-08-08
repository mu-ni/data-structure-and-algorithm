package algorithm.LinkedList;

import algorithm.LinkedList.Dao.ListNode;

public class RemoveNthFromEnd {
    public static void main(String[] args) {
        ListNode head = ListNode.getList(new int[]{1,2,3,4,5});
        System.out.println(removeNthFromEnd(head, 3).toString());
    }

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode cur = dummy;
        ListNode nth = dummy;

        for(int i=0; i<=n; i++) {
            nth = nth.next;
        }

        while (nth != null) {
            cur = cur.next;
            nth = nth.next;
        }

        cur.next = cur.next.next;
        return dummy.next;
    }
}
