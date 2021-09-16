package no106_buildTree;

import utils.TreeNode;
import java.util.HashMap;
import java.util.Map;

public class Solution {
    private Map<Integer,Integer> indexMap;
    public TreeNode myBuildTree(int[] postorder, int[] inorder, int postorderLeft, int postorderRight, int inorderLeft, int inorderRight){
        if(postorderLeft>postorderRight){
            return null;
        }
        //后序遍历的最后一个节点就是根节点
        int postorderRoot=postorderRight;
        int postorderRootVal=postorder[postorderRoot];
        //在中序遍历中定位根节点
        int inorderRoot=indexMap.get(postorderRootVal);
        //把根节点建立起来
        TreeNode root=new TreeNode(postorderRootVal);
        //左子树的节点数目
        int sizeLeftSubTree=inorderRoot-inorderLeft;
        root.left=myBuildTree(postorder,inorder,postorderLeft,postorderLeft+sizeLeftSubTree-1,inorderLeft,inorderRoot-1);
        root.right=myBuildTree(postorder,inorder,postorderLeft+sizeLeftSubTree,postorderRight-1,inorderRoot+1,inorderRight);
        return root;
    }
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int n=postorder.length;
        indexMap=new HashMap<>();
        for(int i=0;i<n;i++){
            indexMap.put(inorder[i],i);
        }
        return myBuildTree(postorder,inorder,0,n-1,0,n-1);
    }

    public static void main(String[] args) {
        Solution solution= new Solution();
        int[] inorder = {9,3,15,20,7};
        int[] postorder = {9,15,7,20,3};
        solution.buildTree(inorder,postorder);
    }
}