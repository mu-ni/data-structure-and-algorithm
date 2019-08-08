package algorithm.LinkedList;

import algorithm.LinkedList.Dao.ListNode;

public class RemoveDupSorted {
    public static void main(String[] args) {
        ListNode head = ListNode.getList(new int[]{1,1,2,2,3,4,4});
        System.out.println(removeDuplicates(head).toString());
    }

    public static ListNode removeDuplicates(ListNode head) {
        if(head == null) return head;

        ListNode pre = head;
        ListNode cur = head.next;
        while(cur != null) {
            if(pre.val == cur.val) {
                pre.next = cur.next;
            }else {
                pre = cur;
            }
            cur = cur.next;
        }
        return head;
    }
}
