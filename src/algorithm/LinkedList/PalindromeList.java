package algorithm.LinkedList;

import algorithm.LinkedList.Dao.ListNode;

import java.util.Stack;

public class PalindromeList {
    public static void main(String[] args) {
        System.out.println(isPalindrome(ListNode.getList(new int[]{1,2,2,1})));
        System.out.println(isPalindrome(ListNode.getList(new int[]{1,2,3,2,1})));
    }

    public static boolean isPalindrome(ListNode head) {
        ListNode reversed = reverse(head);

        while (head != null) {
            if(head.val != reversed.val) return false;
            head = head.next;
            reversed = reversed.next;
        }
        return true;
    }

    public static ListNode reverse(ListNode head) {// clone
        ListNode rst = null;
        while (head != null) {
            ListNode node = new ListNode(head.val);
            node.next = rst;
            rst = node;
            head = head.next;
        }

        return rst;
    }

    public static boolean isPalindrome2(ListNode head) {// stack
        ListNode slow = head;
        ListNode fast = head;
        Stack<Integer> stack = new Stack<>();
        while (fast != null && fast.next != null) {
            stack.push(slow.val);
            slow = slow.next;
            fast = fast.next.next;
        }

        if(fast !=  null) { //skip middle
            slow = slow.next;
        }

        while (slow != null) {
            if (stack.pop() != slow.val) return false;
            slow = slow.next;
        }

        return true;
    }
}
