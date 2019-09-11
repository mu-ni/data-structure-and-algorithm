package algorithm.LinkedList.Sort;

import algorithm.LinkedList.Dao.ListNode;

public class InsertionSort {
    public static void main(String[] args) {
        ListNode list = ListNode.getList(new int[]{4,2,1,3});
        System.out.println(new InsertionSort().insertionSortList(list));
    }

    public ListNode insertionSortList(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode dummy = new ListNode(0);
        ListNode pre = dummy;
        while (head != null) {
            pre = dummy;
            while (pre.next != null && pre.next.val < head.val) {
                pre = pre.next;
            }
            ListNode tmp = head.next;
            head.next = pre.next;
            pre.next = head;
            head = tmp;
        }
        return dummy.next;
    }
}
