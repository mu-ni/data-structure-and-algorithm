package algorithm.LinkedList.Sort;

import algorithm.LinkedList.Dao.ListNode;

public class MergeSort {
    public static void main(String[] args) {
        ListNode list = ListNode.getList(new int[]{4,2,1,3});
        System.out.println(new MergeSort().sortList(list));
    }

    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode slow = head;
        ListNode fast = head;
        ListNode pre = null;
        while (fast != null && fast.next != null) {
            pre = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        pre.next = null;

        ListNode l1 = sortList(head);
        ListNode l2 = sortList(slow);

        return merge(l1, l2);
    }

    public ListNode merge(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode merge = dummy;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                merge.next = l1;
                l1 = l1.next;
            } else {
                merge.next = l2;
                l2 = l2.next;
            }
            merge = merge.next;
        }

        if (l1 != null) {
            merge.next = l1;
        }
        if (l2 != null) {
            merge.next = l2;
        }

        return dummy.next;
    }
}
