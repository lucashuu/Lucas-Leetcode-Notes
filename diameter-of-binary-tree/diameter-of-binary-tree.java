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
//根lAS 思路差不多
//dfs 搜索查找最大深度
//最大diamter = 当前顶点最大深度加另一子树的最大深度
//递归结束条件 root == null
//递归细节： 递归左子树和右子树 更新最大深度
//maxPath = 当前左子树最大深度加右子树最大深度
class Solution {
  int maxPath = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        if(root == null){
          return 0;
        }
        maxHeight(root);
        return maxPath;
    }
  public int maxHeight(TreeNode root){
    if(root == null){
      return 0;
    }
    int leftT = 0;
    int rightT = 0;
    if(root.left != null) leftT = maxHeight(root.left);
    if(root.right != null) rightT = maxHeight(root.right);
    maxPath = Math.max(maxPath, leftT + rightT);
    return Math.max(leftT, rightT) + 1;
  }
}