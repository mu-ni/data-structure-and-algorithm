package algorithm.LinkedList;

import algorithm.LinkedList.Dao.ListNode;

public class Intersection {
    public static void main(String[] args) {
        ListNode l1 = ListNode.getList(new int[]{1,2,3,4,5,6});
        ListNode l2 = ListNode.getList(new int[]{7,8,9,10,4,5,6});
        System.out.println(getIntersectionNode(l1, l2).toString());
    }

    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int lenA = len(headA);
        int lenB = len(headB);

        while (lenA > lenB) {
            headA = headA.next;
            lenA--;
        }

        while (lenA < lenB) {
            headB = headB.next;
            lenB--;
        }

        while (headA.val != headB.val) {
            headA = headA.next;
            headB = headB.next;
        }

        return headA;
    }

    public static int len(ListNode head) {
        int len = 0;
        while (head != null) {
            len++;
            head = head.next;
        }
        return len;
    }
}
