package algorithm.LinkedList;

import algorithm.LinkedList.Dao.ListNode;

public class GetMiddleNode {
    public static void main(String[] args) {
        ListNode head = ListNode.getList(new int[]{1,2,3,4,5}); //middle is 3
        System.out.println(getMiddle(head).toString());

        head = ListNode.getList(new int[]{1,2,3,4,5,6}); //middle is 4
        System.out.println(getMiddle(head).toString());

        head = ListNode.getList(new int[]{1});
        System.out.println(getMiddle(head));

        head = ListNode.getList(new int[]{});
        System.out.println(getMiddle(head));
    }

    public static ListNode getMiddle(ListNode head) {
        if(head == null) return null;

        ListNode slow = head;
        ListNode fast = head;

        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }
}
