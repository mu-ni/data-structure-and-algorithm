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

        ListNode pre = dummy;
        ListNode cur = head;
        while (cur != null) {
            while (cur.next != null && cur.val == cur.next.val) {
                cur = cur.next;
            }
            if (pre.next == cur) {
                pre = pre.next;
            } else {
                pre.next = cur.next;
            }
            cur = cur.next;
        }
        return dummy.next;
    }
}
