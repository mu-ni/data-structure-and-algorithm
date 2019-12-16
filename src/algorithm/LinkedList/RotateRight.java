package algorithm.LinkedList;

import algorithm.LinkedList.Dao.ListNode;

public class RotateRight {
    public static void main(String[] args) {
        System.out.println(rotateRight(ListNode.getList(new int[]{1,2,3,4,5}), 2).toString());
        System.out.println(rotateRight2(ListNode.getList(new int[]{1,2,3,4,5}), 2).toString());
        System.out.println(rotateRight3(ListNode.getList(new int[]{1,2,3,4,5}), 2).toString());
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

        fast.next = head;
        head = slow.next;
        slow.next = null;
        return head;
    }

    public static ListNode rotateRight3(ListNode head, int k) {
        if (head == null) return null;
        int len = 0;
        ListNode cur = head;
        while (cur != null) {
            len++;
            cur = cur.next;
        }
        k %= len;
        // no need to rotate
        if (k == 0) return head;

        ListNode slow = head;
        ListNode fast = head;
        for (int i=0; i<k; i++) {
            fast = fast.next;
        }
        for (int i=k; i<len-1; i++) {
            slow = slow.next;
            fast = fast.next;
        }

        ListNode newHead = slow.next;
        slow.next = null;
        fast.next = head;
        return newHead;
    }
}
