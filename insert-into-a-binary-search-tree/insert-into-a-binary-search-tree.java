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
//递归检查当前node是不是小于root 还是大于 然后继续在子树上递归
//递归结束： 到空node
class Solution {
    public TreeNode insertIntoBST(TreeNode root, int val) {
        TreeNode node = new TreeNode(val);
        if(root == null){
            return node;}
        
       return insertBst(root, node);
    }
    public TreeNode insertBst(TreeNode root, TreeNode node){
        if(root == null){
            return node;
        }
         if(node.val < root.val){
           root.left = insertBst(root.left, node);
        }else{
           root.right = insertBst(root.right, node);
        }
        return  root;
    }
}