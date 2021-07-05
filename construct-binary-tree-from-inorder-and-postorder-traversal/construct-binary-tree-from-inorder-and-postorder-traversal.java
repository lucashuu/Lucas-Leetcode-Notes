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
// 9 3 15 20 7
// 9 15 7 20 3
// 3 is the root at the last 
//在in order 里查找顶点 然后 递归添加 左子树右 子树

// 3  inOrder left: 9 inOrder right: 15, 20 , 7
// 3  postOrder left: 9  rigth: 20 7 15
// 递归小树 (inorder left, post orderleft)
//(inorder right, postorder right)
//数组长度为0 结束递归 返回null
class Solution {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if(inorder.length == 0 || postorder.length == 0){
          return null;
        }
         TreeNode root = new TreeNode(postorder[postorder.length - 1]);
        for(int i = 0; i < inorder.length; i++){
          if(inorder[i] == root.val){
            int[] leftInO = Arrays.copyOfRange(inorder,0 , i);
            int[] rightInO = Arrays.copyOfRange(inorder, i + 1, inorder.length);
            int leftNodeNum = i;
            int[] leftPostO = Arrays.copyOfRange(postorder, 0 , leftNodeNum);
            int[] rightPostO = Arrays.copyOfRange(postorder, 0 + leftNodeNum, postorder.length - 1);
            TreeNode seft = buildTree(leftInO, leftPostO);
            TreeNode sight=buildTree(rightInO, rightPostO);
            root.left = seft;
            root.right = sight;
            break;
          }
        }
      return root;
    }
  }
