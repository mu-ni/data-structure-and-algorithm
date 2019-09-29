package algorithm.LinkedList.Remove;

import algorithm.LinkedList.Dao.ListNode;

public class RemoveDupSorted2 {
    public static void main(String[] args) {
        ListNode head = ListNode.getList(new int[]{1,2,3,3,3,4,4,5});
        System.out.println(removeDuplicates(head).toString());

        head = ListNode.getList(new int[]{1,2,3,3,3,4,4,5});
        System.out.println(removeDuplicates2(head).toString());
    }

    public static ListNode removeDuplicates(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode slow = dummy;
        ListNode fast = head;

        while (fast != null) {
            while (fast.next != null && fast.val == fast.next.val) {
                fast = fast.next;
            }
            if (slow.next == fast) {
                slow = fast;
                fast = fast.next;
                continue;
            }
            slow.next = fast.next;
            fast = fast.next;
        }
        return dummy.next;
    }

    public static ListNode removeDuplicates2(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode slow = dummy;
        ListNode fast = head;
        while(slow.next != null && fast != null && fast.next != null) {
            if (slow.next.val != fast.next.val) {
                slow = slow.next;
                fast = fast.next;
                continue;
            }
            while (fast.next != null && fast.val == fast.next.val) {
                fast = fast.next;
            }
            slow.next = fast.next;
            fast = fast.next;
        }
        return dummy.next;
    }
}
