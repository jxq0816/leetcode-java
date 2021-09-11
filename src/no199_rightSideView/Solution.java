package no199_rightSideView;

import utils.TreeNode;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        if(root==null){
            return new ArrayList<Integer>();
        }
        List rs=new ArrayList<Integer>();
        Queue<TreeNode> queue = new ArrayDeque();
        queue.add(root);
        while(queue.isEmpty()==false){
            int size = queue.size();
            for(int i=0;i<size;i++){
                TreeNode parent=queue.poll();
                if(parent.left!=null){
                    queue.add(parent.left);
                }
                if(parent.right!=null){
                    queue.add(parent.right);
                }
                if(i==size-1){
                    rs.add(parent.val);
                }
            }
        }
        return rs;
    }
}
