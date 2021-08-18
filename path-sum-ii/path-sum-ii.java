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
class Solution {
    List<List<Integer>> res;
    List<Integer> ans;
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        //binary tree traverse
        //dfs
        res = new ArrayList<>();
        ans = new ArrayList<>();
        if(root == null){
            return res;
        }
        
        ans.add(root.val);
        dfs(root, targetSum - root.val);
        return res;
    }
    public void dfs(TreeNode root, int target){
       
        
        if(target == 0 && root.left == null && root.right == null){
            res.add(new ArrayList<>(ans));
            return;
        }
        //for all the choices
       
            //System.out.print(root.val);
           if(root.left != null){
               ans.add(root.left.val);
                dfs(root.left, target - root.left.val);
               ans.remove(ans.size() - 1);
            }
            if(root.right != null){
                ans.add(root.right.val);
                 dfs(root.right, target - root.right.val);
                 ans.remove(ans.size() - 1);
            }
            
        
    }
    
}