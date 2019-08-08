package algorithm.LinkedList;

import algorithm.LinkedList.Dao.ListNode;

public class RemoveDupUnsorted {
    public static void main(String[] args) {
        ListNode head = ListNode.getList(new int[]{1,4,2,2,3,1});
        System.out.println(removeDuplicates(head).toString());
    }

    public static ListNode removeDuplicates(ListNode head) {
        ListNode cur = head;
        while(cur != null) {
            ListNode pt = cur;
            while (pt.next != null) {
                if (cur.data == pt.next.data) {
                    pt.next = pt.next.next;
                    continue;
                }
                pt = pt.next;
            }
            cur = cur.next;
        }
        return head;
    }
}
