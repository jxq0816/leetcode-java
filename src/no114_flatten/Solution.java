package no114_flatten;

import utils.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public void flatten(TreeNode root) {
        List<TreeNode> list=new ArrayList<>();
        preTravel(root,list);
        TreeNode pre,cur;
        for(int i=1;i<list.size();i++){
            pre=list.get(i-1);
            cur=list.get(i);
            pre.right=cur;
            pre.left=null;
        }
    }
    public void preTravel(TreeNode root, List<TreeNode> list){
        if(root!=null){
            list.add(root);
            preTravel(root.left,list);
            preTravel(root.right,list);
        }
        return;
    }
}
