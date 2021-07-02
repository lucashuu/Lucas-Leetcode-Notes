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
//中序遍历bst 会产生一个递增序列
//交换顺序错误的node
//创建一个list 中序遍历把node 存入list
//找到前一个比后一个大的node把 交换顺序
// 1 2 3 4 7 5 6
// 1 2 3 4 5 7 6
// 1 2 3 4 5 6 7
class Solution {
    public void recoverTree(TreeNode root) {
        if(root == null){
          return;
        }
        List<TreeNode> list = new ArrayList<>();
        traverse(root, list);
        TreeNode x = null;
        TreeNode y = null;
        for(int i = 0; i < list.size() - 1; i++){
          if(list.get(i).val > list.get(i + 1).val){
            y = list.get(i + 1);
            if(x == null){
              x = list.get(i);
            }
          }
        }
      int temp = x.val;
          x.val = y.val;
          y.val = temp;
    }
    public void traverse(TreeNode root, List<TreeNode> list){
      if(root == null){
        return;
      }
      traverse(root.left, list);
      list.add(root);
      traverse(root.right, list); 
    }
}