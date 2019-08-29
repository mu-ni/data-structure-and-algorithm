package algorithm.LinkedList;

import algorithm.LinkedList.Dao.ListNode;

public class RotateRight {
    public static void main(String[] args) {
        System.out.println(rotateRight(ListNode.getList(new int[]{1,2,3,4,5}), 2).toString());
        System.out.println(rotateRight(ListNode.getList(new int[]{0,1,2}), 4).toString());
        System.out.println(rotateRight2(ListNode.getList(new int[]{1,2,3,4,5}), 2).toString());
    }

    public static ListNode rotateRight(ListNode head, int k) {
        if (head == null) return head;

        ListNode slow = head;
        ListNode fast = head;
        while (k > 0) {
            if (fast == null) {
                fast = head;
                continue;
            }
            fast = fast.next;
            k--;
        }

        if (fast == null) return head;
        while (fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }

        fast.next = head;
        head = slow.next;
        slow.next = null;
        return head;
    }

    public static ListNode rotateRight2(ListNode head, int k) {
        if (head == null) return head;

        ListNode slow = head;
        ListNode fast = head;
        int len = 1;
        while (fast.next != null) {
            fast = fast.next;
            len++;
        }

        k = k%len;
        for (int i=0; i<len-k-1; i++) {
            slow = slow.next;
        }

        if (slow == null) return head;
        fast.next = head;
        head = slow.next;
        slow.next = null;

        return head;
    }
}
