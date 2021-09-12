package no103_zigzagLevelOrder;

import utils.TreeNode;

import java.util.*;

public class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> rs=new ArrayList<>();
        if(root==null){
            return rs;
        }
        Queue<TreeNode> queue=new ArrayDeque();
        queue.add(root);
        int revese=-1;
        while(!queue.isEmpty()){
            int n=queue.size();
            List<Integer> level=new ArrayList<>();
            for(int i=0;i<n;i++){
                TreeNode parent=queue.poll();
                if(parent.left!=null){
                    queue.add(parent.left);
                }
                if(parent.right!=null){
                    queue.add(parent.right);
                }
                level.add(parent.val);
                if(i==n-1){
                    revese*=-1;
                    if(revese==-1){
                        Collections.reverse(level);
                    }
                    rs.add(level);
                }
            }
        }
        return rs;
    }
}
