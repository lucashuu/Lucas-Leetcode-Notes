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
//从T1 中 找到T2 的root 然后检查子树是不是和T2完全一样
//1.T1的左子树和T2一样 //2.T1的右子树和T2一样 //本身完全一样
class Solution {
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if(subRoot == null) return true;
        if(root == null) return false;
        
        return identical(root, subRoot) || isSubTree(root.left, subRoot) || isSubTree(root.right, subRoot);
    }
    public boolean identical(TreeNode root, TreeNode subRoot){
        if(root == null && subRoot == null) return true;
        if(root == null || subRoot == null) return false;
        if(root.val != subRoot.val){
            return false;
        }
        return identical(root.left, subRoot.left) && identical (root.right, subRoot.right);
    }
    public boolean isSubTree(TreeNode root, TreeNode subRoot){
        if(subRoot == null) return true;
        if(root == null) return false;
        return identical(root, subRoot) || isSubTree(root.left, subRoot) || isSubTree(root.right, subRoot);
    }
}