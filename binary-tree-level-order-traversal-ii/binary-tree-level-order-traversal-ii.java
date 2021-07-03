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
// 3  9  20 15 7
//stack -> 3  9 20 15 7
//Use stack to reverse the order
//Queue to store the level order
class Solution {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
      List<List<Integer>> res = new ArrayList<>();
      if(root == null){
        return res;
      }
      Queue<TreeNode> q = new LinkedList<>();
      Stack<List<Integer>> s = new Stack<List<Integer>>();
      q.add(root);
      while(!q.isEmpty()){
        List<Integer> list = new ArrayList<>();
        int qlen = q.size();
        for(int i = 0; i < qlen; i++){
          TreeNode node = q.poll();
          list.add(node.val);
          if(node.left != null) q.add(node.left);
          if(node.right != null) q.add(node.right);
        }
        s.push(list);
      }
      while(!s.isEmpty()){
        res.add(s.pop());
      }
      return res;
    }
}