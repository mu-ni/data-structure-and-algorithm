package algorithm.LinkedList.Reverse;

import algorithm.LinkedList.Dao.ListNode;

public class ReverseAndClone {
    public static void main(String[] args) {
        System.out.println(reverse(ListNode.getList(new int[]{1,2,3,4,5})).toString());
    }

    public static ListNode reverse(ListNode head) {
        ListNode rst = null;
        while (head != null) {
            ListNode node = new ListNode(head.val);
            node.next = rst;
            rst = node;
            head = head.next;
        }
        return rst;
    }
}
