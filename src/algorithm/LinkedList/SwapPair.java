package algorithm.LinkedList;

import algorithm.LinkedList.Dao.ListNode;

public class SwapPair {
    public static void main(String[] args) {
        System.out.println(swapPairs(ListNode.getList(new int[]{1,2,3,4,5})).toString());
        System.out.println(swapPairs2(ListNode.getList(new int[]{1,2,3,4,5})).toString());
        System.out.println(swapPairs3(ListNode.getList(new int[]{1,2,3,4,5})).toString());
    }

    public static ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode cur = dummy;
        while (cur.next != null && cur.next.next != null) {
            ListNode first = cur.next;
            ListNode second = cur.next.next;

            first.next = second.next;
            second.next = first;
            cur.next = second;
            cur = cur.next.next;
        }
        return dummy.next;
    }

    public static ListNode swapPairs2(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode second = head.next;
        ListNode tmp = second.next;
        second.next = head;
        head.next = swapPairs2(tmp);
        return second;
    }

    public static ListNode swapPairs3(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy;
        while (pre.next != null && pre.next.next != null) {
            ListNode even = pre.next;
            ListNode odd = pre.next.next;

            even.next = odd.next;
            odd.next = even;
            pre.next = odd;
            pre = pre.next.next;
        }
        return dummy.next;
    }
}
