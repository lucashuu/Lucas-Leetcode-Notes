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
//二叉树找最大路径和
//三种情况
// a
//b  c
//1. b,a,a's parent
//2. c,a,a's parent 
//3. b a c  
//1, 2递归往上找最长路径 ， 3 不可以继续递归，但可能是最大
//用left 和 right 记录 分支最大路径
//用ans比较并记录第三种情况 left + right + root
//1，2种情况，比较left right 取最大分支，并加上父节点， 返回单边最大分支，给root节点计算用
class Solution {
    int ans = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        sideMax(root);
        return ans;
    }
    
    public int sideMax(TreeNode root) {
        if(root == null){
            return 0;
        }
        int left = Math.max(0, sideMax(root.left));
        int right = Math.max(0, sideMax(root.right));
        
        ans = Math.max(ans, left + right + root.val);
        return Math.max(left, right) + root.val;        
    }
}