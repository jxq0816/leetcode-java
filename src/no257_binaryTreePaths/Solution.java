package no257_binaryTreePaths;

import utils.TreeNode;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> paths = new ArrayList<String>();
        constructPaths(root, "", paths);
        return paths;
    }

    public void constructPaths(TreeNode root, String path, List<String> paths) {
        if (root != null) {
            StringBuffer pathSB = new StringBuffer(path);
            pathSB.append(Integer.toString(root.val));
            if (root.left == null && root.right == null) {  // 当前节点是叶子节点
                paths.add(pathSB.toString());  // 把路径加入到答案中
            } else {
                pathSB.append("->");  // 当前节点不是叶子节点，继续递归遍历
                constructPaths(root.left, pathSB.toString(), paths);
                constructPaths(root.right, pathSB.toString(), paths);
            }
        }
    }

    public static void main(String[] args) {
        TreeNode root=new TreeNode(1);
        TreeNode node2=new TreeNode(2);
        TreeNode node3=new TreeNode(3);
        node3.left=null;
        node3.right=null;
        TreeNode node5=new TreeNode(5);
        node5.left=null;
        node5.right=null;

        root.left=node2;
        root.right=node3;
        node2.left=null;
        node2.right=node5;
        Solution solution=new Solution();
        List<String> paths=solution.binaryTreePaths(root);
        for(String path:paths){
            System.out.println(path);
        }
    }
}
