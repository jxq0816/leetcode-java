package no173_BSTIterator;

import utils.TreeNode;

import java.util.ArrayDeque;
import java.util.Queue;

class BSTIterator {
    Queue<Integer> queue=new ArrayDeque();
    public BSTIterator(TreeNode root) {
        midTravel(root);
        System.out.println();
    }

    public int next() {
        int rs=queue.peek();
        queue.poll();
        return rs;
    }

    public boolean hasNext() {
        return !queue.isEmpty();
    }

    public void midTravel(TreeNode root){
        if(root==null){
            return;
        }
        if(root.left!=null){
            midTravel(root.left);
        }
        queue.add(root.val);
        if(root.right!=null){
            midTravel(root.right);
        }
    }

    public static void main(String[] args) {
        TreeNode root=new TreeNode(7);
        TreeNode node3=new TreeNode(3);
        node3.left=null;
        node3.right=null;
        root.left=node3;
        TreeNode node9=new TreeNode(9);
        node9.left=null;
        node9.right=null;
        TreeNode node20=new TreeNode(20);
        node20.left=null;
        node20.right=null;
        TreeNode node15=new TreeNode(15);
        node15.left=node9;
        node15.right=node20;
        root.right=node15;
        BSTIterator bst=new BSTIterator(root);
        System.out.println();
    }
}