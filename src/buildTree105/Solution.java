package buildTree105;

import utils.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    private Map<Integer,Integer> indexMap;
    public TreeNode myBuildTree(int[] preorder, int[] inorder, int preorderLeft, int preorderRight, int inorderLeft, int inorderRight){
        if(preorderLeft>preorderRight){
            return null;
        }
        //前序遍历的第一个节点就是根节点
        int preorderRoot=preorderLeft;
        int preorderRootVal=preorder[preorderRoot];
        //在中序遍历中定位根节点
        int inorderRoot=indexMap.get(preorderRootVal);
        //把根节点建立起来
        TreeNode root=new TreeNode(preorderRootVal);
        //左子树的节点数目
        int sizeLeftSubTree=inorderRoot-inorderLeft;
        root.left=myBuildTree(preorder,inorder,preorderLeft+1,preorderLeft+sizeLeftSubTree,inorderLeft,inorderRoot-1);
        root.right=myBuildTree(preorder,inorder,preorderLeft+sizeLeftSubTree+1,preorderRight,inorderRoot+1,inorderRight);
        return root;
    }
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int n=preorder.length;
        indexMap=new HashMap<>();
        for(int i=0;i<n;i++){
            indexMap.put(inorder[i],i);
        }
        return myBuildTree(preorder,inorder,0,n-1,0,n-1);
    }

    public static void main(String[] args) {
        Solution solution=new Solution();
        int[] preorder = {3,9,20,15,7};
        int[] inorder = {9,3,15,20,7};
        solution.buildTree(preorder,inorder);
    }
}
