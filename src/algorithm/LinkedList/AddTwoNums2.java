package algorithm.LinkedList;

import algorithm.LinkedList.Dao.ListNode;

import java.util.Stack;

public class AddTwoNums2 {
    public static void main(String[] args) {
        ListNode l1 = ListNode.getList(new int[]{7,2,4,3});
        ListNode l2 = ListNode.getList(new int[]{5,6,4});
        System.out.println(addTwoNumbers2(l1, l2).toString());
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
        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();

        while (l1 != null) {
            stack1.push(l1.val);
            l1 = l1.next;
        }
        while (l2 != null) {
            stack2.push(l2.val);
            l2 = l2.next;
        }

        Stack<Integer> stack = new Stack<>();
        int carry = 0;
        while (!stack1.empty() || !stack2.empty()) {
            int sum = stack1.empty() ? stack2.pop() : stack2.empty() ? stack1.pop() : stack1.pop() + stack2.pop();
            sum += carry;
            stack.push(sum >= 10 ? sum%10 : sum);
            carry = sum >= 10 ? sum/10 : 0;
        }

        if (carry != 0) {
            stack.push(carry);
        }

        ListNode rst = new ListNode(0);
        ListNode cur = rst;
        while (!stack.empty()) {
            cur.next = new ListNode(stack.pop());
            cur = cur.next;
        }

        return rst.next;
    }
}