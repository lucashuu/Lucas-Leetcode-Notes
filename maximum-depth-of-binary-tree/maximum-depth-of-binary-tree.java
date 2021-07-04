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
//计算最大深度，1. 最大深度：  max(左子树深度，右子树深度) + 当前节点所在的一层深度
//            2. 左子树深度： max(左子树的左子树深度，左子树的右子树深度) + 当前节点所在的一层深度
//            3. 右子树深度： max(右子树的左子树深度，右子树的右子树深度) + 当前节点所在的一层深度
//递归停止条件： node 为 nulll
//递归细节： 再次递归计算 max( 左节点最大高度，右节点最大高度)+1
class Solution {
    public int maxDepth(TreeNode root) {
        if(root == null){
          return 0;
        }
      return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }
}