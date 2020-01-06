package algorithm.LinkedList.Remove;

import algorithm.LinkedList.Dao.ListNode;

import java.util.HashMap;
import java.util.Map;

public class RemoveDupSorted2 {
    public static void main(String[] args) {
        ListNode head = ListNode.getList(new int[]{1,2,3,3,3,4,4,5});
        System.out.println(new RemoveDupSorted2().removeDuplicates(head).toString());

        head = ListNode.getList(new int[]{1,2,3,3,3,4,4,5});
        System.out.println(new RemoveDupSorted2().removeDuplicates2(head).toString());

        head = ListNode.getList(new int[]{1,2,3,3,3,4,4,5});
        System.out.println(new RemoveDupSorted2().removeDuplicates3(head).toString());

        head = ListNode.getList(new int[]{1,2,3,3,3,4,4,5});
        System.out.println(new RemoveDupSorted2().removeDuplicates4(head).toString());
    }

    public ListNode removeDuplicates(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode slow = dummy;
        ListNode fast = head;

        while (fast != null) {
            while (fast.next != null && fast.val == fast.next.val) {
                fast = fast.next;
            }
            if (slow.next == fast) {
                slow = fast;
                fast = fast.next;
                continue;
            }
            slow.next = fast.next;
            fast = fast.next;
        }
        return dummy.next;
    }

    public ListNode removeDuplicates2(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode slow = dummy;
        ListNode fast = head;
        while(slow.next != null && fast != null && fast.next != null) {
            if (slow.next.val != fast.next.val) {
                slow = slow.next;
                fast = fast.next;
                continue;
            }
            while (fast.next != null && fast.val == fast.next.val) {
                fast = fast.next;
            }
            slow.next = fast.next;
            fast = fast.next;
        }
        return dummy.next;
    }

    public ListNode removeDuplicates3(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;
        ListNode slow = head;
        ListNode fast = head.next;
        while (fast != null) {
            if (slow.val != fast.val) {
                prev = slow;
                slow = slow.next;
                fast = fast.next;
                continue;
            }
            while (fast.next != null && fast.val == fast.next.val) {
                fast = fast.next;
            }
            prev.next = fast.next;
            slow = fast.next;
            if (fast.next == null) return dummy.next;
            fast = fast.next.next;
        }

        return dummy.next;
    }

    public ListNode removeDuplicates4(ListNode head) {
        if (head == null || head.next == null) return head;
        Map<Integer, Integer> map = new HashMap<>();
        ListNode cur = head;
        while (cur != null) {
            int count = map.getOrDefault(cur.val, 0)+1;
            map.put(cur.val, count);
            cur = cur.next;
        }

        ListNode dummy = new ListNode(0);
        cur = dummy;
        while (head != null) {
            if (map.get(head.val) == 1) {
                cur.next = head;
                cur = cur.next;
            }
            head = head.next;
        }
        cur.next = null;
        return dummy.next;
    }
}
