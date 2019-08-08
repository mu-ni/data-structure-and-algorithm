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
            ListNode prev = cur;
            ListNode cur2 = cur.next;
            while (cur2 != null) {
                if(cur.data == cur2.data) {
                    prev.next = cur2.next;
                }
                prev = cur2;
                cur2 = cur2.next;
            }
            cur = cur.next;
        }
        return head;
    }
}
