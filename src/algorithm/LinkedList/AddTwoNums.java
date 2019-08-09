package algorithm.LinkedList;

import algorithm.LinkedList.Dao.ListNode;

public class AddTwoNums {
    public static void main(String[] args) {
        ListNode l1 = ListNode.getList(new int[]{2,4,3});
        ListNode l2 = ListNode.getList(new int[]{5,6,4});
        System.out.println(addTwoNumbers(l1, l2).toString());
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode rst = dummy;

        int carry = 0;
        while(l1 != null || l2 != null) {
            int sum = l1 == null ? l2.val : l2 == null ? l1.val : l1.val + l2.val;
            sum += carry;

            int val = sum >= 10 ? sum%10 : sum;
            carry = sum >= 10 ? sum/10 : 0;
            rst.next = new ListNode(val);

            rst = rst.next;
            l1 = l1 == null ? null : l1.next;
            l2 = l2 == null ? null : l2.next;
        }

        if (carry != 0) { // don't forget
            rst.next = new ListNode(carry);
        }

        return dummy.next;
    }
}
