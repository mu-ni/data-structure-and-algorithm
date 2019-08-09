package algorithm.LinkedList;

import algorithm.LinkedList.Dao.ListNode;

public class AddTwoNums2 {
    public static void main(String[] args) {
        ListNode l1 = ListNode.getList(new int[]{7,2,4,3});
        ListNode l2 = ListNode.getList(new int[]{5,6,4});
        System.out.println(addTwoNumbers(l1, l2).toString());
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        l1 = reverse(l1);
        l2 = reverse(l2);

        ListNode rst = AddTwoNums.addTwoNumbers(l1, l2);
        return reverse(rst);
    }

    public static ListNode reverse(ListNode head) { // in place
        ListNode pre = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode tmp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = tmp;
        }
        return pre;
    }

    public static ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
        // stack
        return null;
    }
}