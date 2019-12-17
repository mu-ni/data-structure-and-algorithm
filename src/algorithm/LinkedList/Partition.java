package algorithm.LinkedList;

import algorithm.LinkedList.Dao.ListNode;

public class Partition {
    public static void main(String[] args) {
        ListNode head = ListNode.getList(new int[]{3,5,8,5,10,2,1});
        System.out.println(partition(head, 5).toString());
        head = ListNode.getList(new int[]{3,5,8,5,10,2,1});
        System.out.println(partition2(head, 5).toString());
    }

    public static ListNode partition(ListNode head, int x) {
        ListNode dummy1 = new ListNode(0);
        ListNode dummy2 = new ListNode(0);
        ListNode smaller = dummy1;
        ListNode larger = dummy2;

        while (head != null) {
            if (head.val < x) {
                smaller.next = head;
                smaller = smaller.next;
            } else {
                larger.next = head;
                larger = larger.next;
            }
            head = head.next;
        }

        larger.next = null;
        smaller.next = dummy2.next;
        return dummy1.next;
    }

    public static ListNode partition2(ListNode head, int x) {
        ListNode lessHead = new ListNode(0);
        ListNode less = lessHead;
        ListNode moreHead = new ListNode(0);
        ListNode more = moreHead;

        ListNode cur = head;
        while (cur != null) {
            if (cur.val < x) {
                less.next = cur;
                less = less.next;
            } else {
                more.next = cur;
                more = more.next;
            }
            cur = cur.next;
        }
        more.next = null;
        less.next = moreHead.next;
        return lessHead.next;
    }
}
