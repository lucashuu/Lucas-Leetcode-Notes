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
//BST 特性 中序遍历 即得有序数组, 找到相邻两树最小的差值 

class Solution {
int minV = Integer.MAX_VALUE;
private TreeNode prev = null;

    public int getMinimumDifference(TreeNode root) {
        if(root == null){
            return 0;
        }        
        getMinimumDifference(root.left);
        if(prev != null)
            minV = Math.min(minV, root.val - prev.val);
        prev = root;
        getMinimumDifference(root.right);
        
        return minV;
        
    }
}