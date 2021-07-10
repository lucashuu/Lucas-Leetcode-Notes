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
//递归的把左子树push进stack 7, 3
//pop出node 如果此node有右子node 把右子node push 进stack 接这检查此node 有没有左子树把左子node push 进stack
//pop 7 15 stack push 9 -> 9 
//pop 15 push 20
class BSTIterator {
    
    Stack<TreeNode> s;
    public BSTIterator(TreeNode root) {
        s = new Stack<TreeNode>();
        if (root == null) return;
        while(root != null){
            s.push(root);
            root = root.left;
        }
    }
    
    public int next() {
        TreeNode cur = s.pop();
        int res = cur.val;
        TreeNode leftChild = cur.right;
        
        while(leftChild != null){
            s.push(leftChild);
            leftChild = leftChild.left;
        }
        return cur.val;
    }
    
    public boolean hasNext() {
        return !s.isEmpty();
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */