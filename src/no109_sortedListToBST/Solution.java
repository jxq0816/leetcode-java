package no109_sortedListToBST;

import utils.ListNode;
import utils.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public TreeNode sortedListToBST(ListNode head) {
        List<Integer> list=new ArrayList<>();
        while(head!=null){
            list.add(head.val);
            head=head.next;
        }
        return construct(list);
    }
    public TreeNode construct(List<Integer> list){
        int n=list.size();
        if(n==0){
            return null;
        }
        TreeNode root=new TreeNode(list.get(n/2));
        if(n==1){
            root.left=null;
            root.right=null;
            return root;
        }
        List<Integer> leftList=new ArrayList<>();
        for(int i=0;i<n/2;i++){
            leftList.add(list.get(i));
        }
        List<Integer> rightList=new ArrayList<>();
        for(int i=n/2+1;i<n;i++){
            rightList.add(list.get(i));
        }
        TreeNode left=construct(leftList);
        TreeNode right=construct(rightList);
        root.left=left;
        root.right=right;
        return root;
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
        Solution solution=new Solution();
        TreeNode rs=solution.sortedListToBST(head);
        System.out.println();
    }
}
