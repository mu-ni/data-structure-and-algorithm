package algorithm.LinkedList;

import algorithm.LinkedList.Dao.ListNode;

public class ReverseMN {
    public static void main(String[] args) {
        System.out.println(reverse(ListNode.getList(new int[]{1,2,3,4,5,6,7}), 2,6).toString());
    }

    // reverse m~n
    public static ListNode reverse(ListNode head, int m, int n) {
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
}
