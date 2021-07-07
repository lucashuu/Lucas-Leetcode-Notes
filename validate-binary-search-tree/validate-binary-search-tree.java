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
    public boolean isValidBST(TreeNode root) {
        if(root == null){
            return true;
        }
        return helper(root);
}   
    long prev= Long.MIN_VALUE;
    public boolean helper(TreeNode root){
        if(root == null){
            return true;
        }
        if(isValidBST(root.left)){
         
               
            if(root.val <= prev){
                return false;
                }   
             
             prev = root.val;
        if(!isValidBST(root.right)){
            return false;
            }    
        }else{
            return false;
        }  
        return true;
    }
}