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
// dfs 
// 96的升级题 
// 如果给定n 回溯生成root 的左子树 和 右子树
// 但是这样只生成了一棵数
// 我们考虑如果要生成所有的数    1 .... n   都可以作为root节点
// 之后要给每个root 节点 生成 左子树和右子树
// 因为要考虑所有的可能 所以 建立 左子树list 和 右子树list 把 左右子树两两配对  总共每一个root 下右 left.size * right.size 种不同的组合/数
// 建立一个list 把 root 节点加入list 中最后返回list

class Solution {
    public List<TreeNode> generateTrees(int n) {
        
        return getTree(1, n);
    }
    public List<TreeNode> getTree(int start, int end) {
        List<TreeNode> ans = new ArrayList<>();
        //没有剩余的节点了
        if(start > end){
            ans.add(null);
            return ans;
        }
        //只有一个节点 一种可能
        if(start == end){
            ans.add(new TreeNode(start));
            return ans;
        }
        //其它情况 遍历所有节点 做为root
        for(int i = start; i <= end; i++){
            //得到左右子树列表
            List<TreeNode> left = getTree(start, i - 1);
            List<TreeNode> right = getTree(i + 1, end );
            
            for(TreeNode leftN : left){
                for(TreeNode rightN : right){
                    TreeNode root = new TreeNode(i);
                    root.left = leftN;
                    root.right = rightN;
                    ans.add(root);
                }
            }
            
            
        }
        
     return ans;   
        
    }
}