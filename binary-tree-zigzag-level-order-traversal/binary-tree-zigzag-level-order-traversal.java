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
//odd level use Collections.reverse()
//even level same as level order traverse
class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if(root == null){
            return res;
        }
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.offer(root);
        boolean odd = false;
        while(!q.isEmpty()){
            int qlen = q.size();
            List<Integer> list = new ArrayList<Integer>();
            for(int i = 0; i < qlen; i++){
                TreeNode node = q.poll();
                list.add(node.val);
                if(node.left != null) q.offer(node.left);
                if(node.right != null) q.offer(node.right);
            }
            if(!odd){
                res.add(list);
            }else{
                Collections.reverse(list);
                res.add(list);
            }
             odd = !odd;
    }
        return res;
}
}