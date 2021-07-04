/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
//自底向上 递归 -> 后序遍历
//三种情况
//1. 如果两个节点在root的两侧则直接返回root
//2. 如果两个节点中的一个节点== root 也直接返回root
//3. 如果左返回null 或者右返回null 则说明节点在另一棵子树里
//    如果左null 两个节点在右子树
//              1. right 返回 其中一个节点 
//              2.  right 返回 root 
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
      if(root == null){
        return root;
      }
      if(p == root || q == root){
        return root;
      }
      TreeNode left = lowestCommonAncestor(root.left, p, q);
      TreeNode right = lowestCommonAncestor(root.right, p, q);
      if(left != null && right != null){
        return root;
      }
      if(left == null) return right;
      if(right == null) return left;
      return null;
    }
}