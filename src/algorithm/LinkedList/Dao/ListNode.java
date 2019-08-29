package algorithm.LinkedList.Dao;

public class ListNode {
    public int val;
    public ListNode next;

    public ListNode(int val) {
        this.val = val;
    }

    public static ListNode getList(int[] arr) {
        if (arr.length == 0) return null;
        if (arr.length == 1) return new ListNode(arr[0]);

        ListNode head = new ListNode(arr[0]);
        ListNode cur = null;
        for(int i=1; i< arr.length; i++) {
            ListNode node = new ListNode(arr[i]);
            if (cur == null) {
                head.next = node;
            } else {
                cur.next = node;
            }
            cur = node;
        }
        return head;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        ListNode cur = this;
        int len = 0;
        while(cur != null && ++len < 10) {
            sb.append(cur.val);
            sb.append(" -> ");
            cur = cur.next;
        }
        if (len == 10) sb.append("...");
        return sb.toString();
    }
}
