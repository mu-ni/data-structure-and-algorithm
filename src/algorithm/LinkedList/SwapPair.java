package algorithm.LinkedList;

import algorithm.LinkedList.Dao.ListNode;

public class SwapPair {
    public static void main(String[] args) {
        System.out.println(swapPairs(ListNode.getList(new int[]{1,2,3,4,5})).toString());
        System.out.println(swapPairs2(ListNode.getList(new int[]{1,2,3,4,5})).toString());
        System.out.println(swapPairs3(ListNode.getList(new int[]{1,2,3,4,5})).toString());
        System.out.println(swapPairs4(ListNode.getList(new int[]{1,2,3,4,5})).toString());
    }

    public static ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode cur = dummy;
        while (cur.next != null && cur.next.next != null) {
            ListNode first = cur.next;
            ListNode second = cur.next.next;

            first.next = second.next;
            second.next = first;
            cur.next = second;
            cur = cur.next.next;
        }
        return dummy.next;
    }

    public static ListNode swapPairs2(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode second = head.next;
        ListNode rest = second.next;
        second.next = head;
        head.next = swapPairs2(rest);
        return second;
    }

    public static ListNode swapPairs3(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy;
        while (pre.next != null && pre.next.next != null) {
            ListNode even = pre.next;
            ListNode odd = pre.next.next;

            even.next = odd.next;
            odd.next = even;
            pre.next = odd;
            pre = pre.next.next;
        }
        return dummy.next;
    }

    public static ListNode swapPairs4(ListNode head) {
        ListNode evenHead = new ListNode(0);
        ListNode even = evenHead;
        ListNode oddHead = new ListNode(0);
        ListNode odd = oddHead;

        boolean isEven = false;
        while (head != null) {
            if (isEven) {
                even.next = head;
                even = even.next;
                isEven = false;
            } else {
                odd.next = head;
                odd = odd.next;
                isEven = true;
            }
            head = head.next;
        }
        even.next = null;
        odd.next = null;

        ListNode rst = new ListNode(0);
        ListNode cur = rst;
        even = evenHead.next;
        odd = oddHead.next;
        isEven = true;
        while (even != null && odd != null) {
            if (isEven) {
                cur.next = even;
                even = even.next;
                isEven = false;
            } else {
                cur.next = odd;
                odd = odd.next;
                isEven = true;
            }
            cur = cur.next;
        }
        while (even != null) {
            cur.next = even;
            cur = cur.next;
            even = even.next;
        }
        while (odd != null) {
            cur.next = odd;
            cur = cur.next;
            odd = odd.next;
        }
        return rst.next;
    }
}
