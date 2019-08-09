package algorithm.LinkedList;

import algorithm.LinkedList.Dao.ListNode;

public class HasCycle {
    public static void main(String[] args) {
        System.out.println(hasCycle(ListNode.getList(new int[]{1,2,3,4,2,3,5})));
        System.out.println(hasCycle(ListNode.getList(new int[]{1,2,3,4,2,3,4})));
    }

    public static boolean hasCycle(ListNode head) {
        if (head == null) return false;

        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow.val == fast.val) return true;
        }
        return false;
    }
}
