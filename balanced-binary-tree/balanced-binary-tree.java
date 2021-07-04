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
//跟返回最大深度题类似
//dfs 遍历递归返回最大高度 如果高度大于1则返回-1
//返回-1之后，肯定是某个left node 或者 right node 接盘
//所以 检测深度 > 1 时也检测下 left node 或者right node 是不是也是-1
//返回高度是不是为-1
class Solution {
    public boolean isBalanced(TreeNode root) {
        if(root == null){
          return true;
        }
        int depth = 0;
       return dfs(root) != -1;
    }
    public  int dfs(TreeNode root){
        if(root == null){
          return 0;
        }
        int leftMax = dfs(root.left);
        int rightMax = dfs(root.right);
        if(Math.abs(leftMax - rightMax) > 1 || leftMax == -1 || rightMax == -1){
          return - 1;
        }
        return Math.max(leftMax, rightMax) + 1;
    }
}