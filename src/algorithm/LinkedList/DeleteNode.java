package algorithm.LinkedList;

import algorithm.LinkedList.Dao.ListNode;

public class DeleteNode {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(5);
        head.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;

        deleteNode(head);
        System.out.println(head.toString());
        deleteNode(n3);
        System.out.println(head.toString());
    }

    public static void deleteNode(ListNode node) { //except the tail
        if(node == null || node.next == null) {
            // error -> node is tail
            return;
        }
        node.val = node.next.val; // copy next value
        node.next = node.next.next; // delete next node
    }
}
