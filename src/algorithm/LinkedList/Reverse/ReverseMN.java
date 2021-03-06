package algorithm.LinkedList.Reverse;

import algorithm.LinkedList.Dao.ListNode;

public class ReverseMN {
    public static void main(String[] args) {
        System.out.println(reverseBetween(ListNode.getList(new int[]{1,2,3,4,5,6,7}), 2,6).toString());
        System.out.println(reverseBetween2(ListNode.getList(new int[]{1,2,3,4,5,6,7}), 2,6).toString());
    }

    // reverse m~n
    public static ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode pre1 = null;
        ListNode cur1 = dummy;
        for (int i=0; i<m; i++) {
            pre1 = cur1;
            cur1 = cur1.next;
        }

        ListNode pre2 = pre1;
        ListNode cur2 = cur1;
        for (int i=m; i<=n; i++) {
            ListNode tmp = cur2.next;
            cur2.next = pre2;
            pre2 = cur2;
            cur2 = tmp;
        }

        pre1.next = pre2;
        cur1.next = cur2;

        return dummy.next;
    }

    public static ListNode reverseBetween2(ListNode head, int m, int n) {
        if (m <= 1) {
            return ReverseN.reverseN(head, n - m + 1);
        }
        head.next = reverseBetween(head.next, m - 1, n - 1);
        return head;
    }
}
