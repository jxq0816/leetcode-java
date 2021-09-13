package no109_sortedListToBST;

import utils.ListNode;
import utils.TreeNode;

public class Solution2 {
    public ListNode getMid(ListNode left,ListNode right){
        ListNode slow=left;
        ListNode fast=left;
        while(fast!=right&&fast.next!=right){
            slow=slow.next;
            fast=fast.next;
            fast=fast.next;
        }
        return slow;
    }
    public TreeNode buildTree(ListNode left,ListNode right){
        if(left==right){
            return null;
        }
        ListNode mid=getMid(left,right);
        TreeNode root=new TreeNode(mid.val);
        root.left=buildTree(left,mid);
        root.right=buildTree(mid.next,right);
        return root;
    }
    public TreeNode sortedListToBST(ListNode head) {
        return buildTree(head,null);
    }
    public static void main(String[] args) {
        ListNode head=new ListNode(-10);
        ListNode node2=new ListNode(-3);
        ListNode node3=new ListNode(0);
        ListNode node4=new ListNode(5);
        ListNode node5=new ListNode(9);
        head.next=node2;
        node2.next=node3;
        node3.next=node4;
        node4.next=node5;
        node5.next=null;
        Solution2 solution=new Solution2();
        TreeNode rs=solution.sortedListToBST(head);
        System.out.println();
    }
}
