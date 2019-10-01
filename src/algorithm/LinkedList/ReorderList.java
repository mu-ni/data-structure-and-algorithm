package algorithm.LinkedList;

import algorithm.LinkedList.Dao.ListNode;

public class ReorderList {
    public static void main(String[] args) {
        ListNode list = ListNode.getList(new int[]{1,2,3,4,5});
        new ReorderList().reorderList(list);
        System.out.println(list);

        list = ListNode.getList(new int[]{1,2,3,4,5});
        new ReorderList().reorderList2(list);
        System.out.println(list);
    }

    public void reorderList(ListNode head) {
        if(head == null || head.next == null) return;

        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode head2 = reverse(slow.next);
        slow.next = null;
        while(head != null && head2 != null) {
            ListNode tmp1 = head.next;
            ListNode tmp2 = head2.next;

            head2.next = head.next;
            head.next = head2;

            head = tmp1;
            head2 = tmp2;
        }
    }

    public ListNode reverse(ListNode head) {
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

    public void reorderList2(ListNode head) {
        if (head == null || head.next == null) return;
        ListNode pre = null;
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            pre = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        if (fast != null) {
            pre = slow;
            slow = slow.next;
        }
        pre.next = null;

        ListNode rev = reverse(slow);
        ListNode cur = head;
        while (cur != null && rev != null) {
            ListNode tmp1 = cur.next;
            ListNode tmp2 = rev.next;
            cur.next = rev;
            rev.next = tmp1;
            cur = tmp1;
            rev = tmp2;
        }
    }
}
