package algorithm.LinkedList;

import algorithm.LinkedList.Dao.ListNode;

public class RemoveDupSorted2 {
    public static void main(String[] args) {
        ListNode head = ListNode.getList(new int[]{1,2,3,3,3,4,4,5});
        System.out.println(removeDuplicates(head).toString());
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
}
