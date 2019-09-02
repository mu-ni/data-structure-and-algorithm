package algorithm.LinkedList;

import algorithm.LinkedList.Dao.ListNode;

public class MergeKSortedList {
    public static void main(String[] args) {
        ListNode[] lists = new ListNode[]{ListNode.getList(new int[]{1,4,5}),
                ListNode.getList(new int[]{1,3,4}), ListNode.getList(new int[]{2,6})};
        System.out.println(new MergeKSortedList().mergeKLists(lists).toString());
    }

    public ListNode mergeKLists(ListNode[] lists) {
        return merge(lists, 0, lists.length-1);
    }

    public ListNode merge(ListNode[] lists, int start, int end) {
        if (start > end) return null;
        if (start == end) return lists[start];
        int mid = start + (end - start)/2;
        ListNode left = merge(lists, start, mid);
        ListNode right = merge(lists, mid+1, end);
        return merge2(left, right);
    }


    public ListNode merge2(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        if (l1.val <= l2.val) {
            l1.next = merge2(l1.next, l2);
            return l1;
        }
        l2.next = merge2(l1, l2.next);
        return l2;
    }
}
