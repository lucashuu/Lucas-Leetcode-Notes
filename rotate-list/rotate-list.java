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
// 找到旋转节点  分割数组  , 倒数第N个节点
class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null || head.next == null){
            return head;
        }
        int len = 1;
        ListNode tail = head;
        
        while(tail.next != null){
            tail = tail.next;
            len++;
        }
        k = k % len;
        ListNode fast = head;
        for(int i = 0; i < k; i++){
            fast = fast.next;
        }
        ListNode slow = head;
        while(fast.next != null){
            slow = slow.next;
            fast = fast.next;
        }
        tail.next = head;
        head = slow.next;
        slow.next = null;
                return head;

    }
    
}