package algorithm.LinkedList;

import algorithm.LinkedList.Dao.ListNode;

public class DetectCycle {
    public static void main(String[] args) {
        System.out.println(detectCycle(ListNode.getList(new int[]{1,2,3,4,2,3,4,2,3,4})));
    }

    public static ListNode detectCycle(ListNode head) {
        if (head == null) return null;

        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow.val == fast.val) break;
        }

        slow = head;
        while (slow.val != fast.val) {
            slow = slow.next;
            fast = fast.next;
        }

        return slow;
    }
}
