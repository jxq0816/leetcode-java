package no116_connect;
import utils.Node;

import java.util.ArrayDeque;
import java.util.Queue;

public class Solution {
    public Node connect(Node root) {
        if(root==null){
            return null;
        }
        Queue<Node> queue=new ArrayDeque();
        queue.add(root);
        while(queue.isEmpty()==false){
            int n=queue.size();
            for(int i=0;i<n;i++){
                Node parent=queue.poll();
                if(i==n-1){
                    parent.next=null;
                }else{
                    parent.next=queue.peek();
                }
                Node leftNode=parent.left;
                Node rightNode=parent.right;
                if(leftNode!=null){
                    queue.add(leftNode);
                }
                if(rightNode!=null){
                    queue.add(rightNode);
                }
            }
        }
        return root;
    }

    public static void main(String[] args) {
        Node node1=new Node(1);
        Node node2=new Node(2);
        Node node3=new Node(3);
        Node node4=new Node(4);
        Node node5=new Node(5);
        Node node6=new Node(6);
        Node node7=new Node(7);
        node1.left=node2;
        node1.right=node3;
        node2.left=node4;
        node2.right=node5;
        node3.left=node6;
        node3.right=node7;
        node4.left=null;
        node4.right=null;
        node5.left=null;
        node5.right=null;
        node6.left=null;
        node6.right=null;
        node7.left=null;
        node7.right=null;
        Solution solution=new Solution();
        solution.connect(node1);
    }
}