/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
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
//跟108题array中reconstruct BST 的思路相同
//list的特性 设置两个指针 找中间节点
//一个 slow 一个 fast ， fast reach到list末尾时 slow就是中间节点
//找到中间节点后，slow的next定义为null break 链表
//左边就是左子树 右边就是右子树
class Solution {
    public TreeNode sortedListToBST(ListNode head) {
        if(head == null){
            return null;
        }
        if(head.next == null){
            TreeNode node = new TreeNode(head.val);
            return node;
        }
        ListNode slow = head; 
        ListNode fast = head;
        ListNode pre = null;
        while(fast != null && fast.next != null){
            pre = slow;
            slow = slow.next;
            fast = fast.next.next;
           
        }
        TreeNode node = new TreeNode(slow.val);
            pre.next = null;
            node.left = sortedListToBST(head);
            node.right = sortedListToBST(slow.next);
        return node;
    }
}