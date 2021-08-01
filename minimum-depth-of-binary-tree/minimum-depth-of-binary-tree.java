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
//dfs 找最浅的深度 深度是从root 到 leaf
class Solution {
    
    public int minDepth(TreeNode root) {
        if(root == null){
            return 0;
        }
       if(root.left == null && root.right == null) return 1;
       
        return dfs(root);
    }
    public int dfs(TreeNode root){
        if(root == null){
            return 0;
        }
        if(root.left == null && root.right == null){
            return 1;
        }
        int leftDepth = dfs(root.left);
        int rightDepth = dfs(root.right);
        int ans = Integer.MAX_VALUE;
        
        if(leftDepth != 0){
            ans = Math.min(leftDepth, ans);
        }
        
        if(rightDepth != 0){
            ans = Math.min(rightDepth, ans);
        }
        return ans + 1;
        
    }
}