package algorithm.LinkedList;

import algorithm.LinkedList.Dao.ListNode;

public class Partition {
    public static void main(String[] args) {
        ListNode head = ListNode.getList(new int[]{3,5,8,5,10,2,1});
        System.out.println(partition(head, 5).toString());
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
}
