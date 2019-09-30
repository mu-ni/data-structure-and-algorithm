package algorithm.Tree;

import algorithm.LinkedList.Dao.ListNode;
import algorithm.Tree.Dao.TreeNode;
import algorithm.Tree.Traversal.PreOrder;

public class SortedListToBST {
    public static void main(String[] args) {
        TreeNode tree = new SortedListToBST().sortedListToBST(ListNode.getList(new int[]{-10,-3,0,5,9}));
        System.out.println(new PreOrder().preOrder(tree));
    }

    public TreeNode sortedListToBST(ListNode head) {
        return helper(head, null);
    }

    public TreeNode helper(ListNode head, ListNode tail) {
        if (head == tail) return null;

        ListNode slow = head;
        ListNode fast = head;
        while (fast != tail && fast.next != tail) {
            slow = slow.next;
            fast = fast.next.next;
        }
        TreeNode root = new TreeNode(slow.val);
        root.left = helper(head, slow);
        root.right = helper(slow.next, tail);
        return root;
    }
}
