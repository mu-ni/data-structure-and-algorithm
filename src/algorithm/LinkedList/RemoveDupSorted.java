package algorithm.LinkedList;

import algorithm.LinkedList.Dao.ListNode;

public class RemoveDupSorted {
    public static void main(String[] args) {
        ListNode head = ListNode.getList(new int[]{1,1,2,2,3,4,4});
        System.out.println(removeDuplicates(head).toString());
        head = ListNode.getList(new int[]{1,1,2,2,3,4,4});
        System.out.println(removeDuplicates2(head).toString());
    }

    public static ListNode removeDuplicates(ListNode head) {
        if (head == null) return head;

        ListNode slow = head;
        ListNode fast = head.next;
        while (fast != null) {
            if (slow.val == fast.val) {
                slow.next = fast.next;
                fast = fast.next;
                continue;
            }
            slow = fast;
            fast = fast.next;
        }
        return head;
    }

    public static ListNode removeDuplicates2(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null) {
            while (fast.next != null && fast.val == fast.next.val) {
                fast = fast.next;
            }
            slow.next = fast.next;
            slow = slow.next;
            fast = fast.next;
        }
        return head;
    }
}
