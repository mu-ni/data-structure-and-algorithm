package algorithm.LinkedList;

import algorithm.LinkedList.Dao.ListNode;

public class Partition {
    public static void main(String[] args) {
        ListNode head = ListNode.getList(new int[]{3,5,8,5,10,2,1});
        System.out.println(partition(head, 5).toString());
    }

    public static ListNode partition(ListNode head, int x) {
        ListNode less = new ListNode(0);
        ListNode more = new ListNode(0);
        ListNode lessCur = less;
        ListNode moreCur = more;

        ListNode cur = head;
        while(cur != null) {
            if(cur.val < x) {
                lessCur.next = cur;
                lessCur = lessCur.next;
            } else {
                moreCur.next = cur;
                moreCur = moreCur.next;
            }
            cur = cur.next;
        }

        lessCur.next = more.next;
        moreCur.next = null; // rm cur.next
        return less.next;
    }
}
