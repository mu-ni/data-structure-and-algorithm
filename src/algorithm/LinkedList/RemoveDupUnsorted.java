package algorithm.LinkedList;

import algorithm.LinkedList.Dao.ListNode;

import java.util.HashSet;
import java.util.Set;

public class RemoveDupUnsorted {
    public static void main(String[] args) {
        ListNode head = ListNode.getList(new int[]{1,4,2,2,3,1});
        System.out.println(removeDuplicates(head).toString());
    }

    public static ListNode removeDuplicates(ListNode head) {
        Set<Integer> map = new HashSet<>();
        map.add(head.data);

        ListNode cur = head;
        while(cur.next != null) {
            if(map.contains(cur.next.data)) {
                cur.next = cur.next.next;
                continue;
            }
            map.add(cur.next.data);
            cur = cur.next;
        }
        return head;
    }

    public static ListNode removeDuplicates2(ListNode head) {
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
