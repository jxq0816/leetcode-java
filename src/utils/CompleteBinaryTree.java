package utils;

import java.util.LinkedList;
import java.util.Queue;

public class CompleteBinaryTree {
    //完全二叉树
    public boolean travel(TreeNode root){
        Queue<TreeNode> que=new LinkedList();
        que.add(root);
        TreeNode node=null;
        while((node=que.poll())!=null){
            que.add(node.left);
            que.add(node.right);
        }
        while(!que.isEmpty()){
            node=que.poll();
            if(node!=null){
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        TreeNode root=new TreeNode(1);
        TreeNode leftNode=new TreeNode(2);
        TreeNode rightNode=new TreeNode(3);
        root.left=leftNode;
        root.right=rightNode;
        leftNode.left=null;
        leftNode.right=null;
        rightNode.left=null;
        rightNode.right=null;
        CompleteBinaryTree demo=new CompleteBinaryTree();
        boolean rs=demo.travel(root);
        System.out.println(rs);
    }
}


