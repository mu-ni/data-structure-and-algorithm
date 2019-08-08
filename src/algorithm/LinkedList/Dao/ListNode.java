package algorithm.LinkedList.Dao;

public class ListNode {
    public int data;
    public ListNode next;

    public ListNode(int val) {
        this.data = val;
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
        while(cur != null) {
            sb.append(cur.data);
            sb.append(" -> ");
            cur = cur.next;
        }
        return sb.toString();
    }
}
