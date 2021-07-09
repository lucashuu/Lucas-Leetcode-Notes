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
//中序遍历 bst 构成生序列数组
//选取中间节点进行递归构成bst 左边是左子树 右边是右子树
class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        if(nums.length == 0 || nums == null){
            return null;
        }
        return dfs(nums, 0 , nums.length - 1);
    }
    public TreeNode dfs(int[] nums, int start, int end){
        if(start > end){
            return null;
        }
        int mid = start + (end - start) / 2;
        TreeNode node = new TreeNode(nums[mid]);
        node.left = dfs(nums, start, mid -1);
        node.right = dfs(nums, mid + 1, end);
        return node;
    }
}