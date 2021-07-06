/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
//判断一棵树是不是另一棵树的子树
//需要判断 1. 判断 t  是不是 和 s 相等
//        2. 判断 t 是否和树 s 的任意子树相等
class Solution {
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if(subRoot == null) return true;
        if(root == null) return false;
        return isIdentical(root, subRoot) || isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }
    public boolean isIdentical(TreeNode root, TreeNode subRoot){
        if(root == null && subRoot == null){
            return true;
        }
        if(subRoot == null) return false;
        if(root == null) return false;
        if(root.val != subRoot.val) return false;
        return isIdentical(root.left, subRoot.left) && isIdentical(root.right, subRoot.right);
    }
}