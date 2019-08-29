package algorithm.LinkedList;

import algorithm.LinkedList.Dao.ListNode;

public class RotateRight {
    public static void main(String[] args) {
        System.out.println(rotateRight(ListNode.getList(new int[]{1,2,3,4,5}), 2).toString());
        System.out.println(rotateRight(ListNode.getList(new int[]{0,1,2}), 4).toString());
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
}
