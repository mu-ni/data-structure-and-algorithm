package algorithm.ArrayAndString;

import algorithm.LinkedList.Dao.ListNode;

public class MergeSortedList {
    public static void main(String[] args) {
        System.out.println(mergeTwoLists(ListNode.getList(new int[]{1,2,4}), ListNode.getList(new int[]{1,3,4})).toString());
        System.out.println(mergeTwoLists2(ListNode.getList(new int[]{1,2,4}), ListNode.getList(new int[]{1,3,4})).toString());
    }

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        while(l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                cur.next = l1;
                l1 = l1.next;
            } else {
                cur.next = l2;
                l2 = l2.next;
            }
            cur = cur.next;
        }
        while (l1 != null) {
            cur.next = l1;
            l1 = l1.next;
            cur = cur.next;
        }
        while (l2 != null) {
            cur.next = l2;
            l2 = l2.next;
            cur = cur.next;
        }
        return dummy.next;
    }

    public static ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        if (l1.val <= l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        }
        l2.next = mergeTwoLists(l1, l2.next);
        return l2;
    }
}
