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
//使用辅助栈 push 前半段 out 的时候和后面比
// 1 2 2 1     1 -> 2 ->
class Solution {
    public boolean isPalindrome(ListNode head) {
        if(head == null || head.next == null){
            return true;
        }
        ListNode slow = head;
        ListNode fast = head;
        Stack<Integer> s = new Stack<>();
        while(fast.next != null && fast.next.next != null){
            s.push(slow.val);
            slow = slow.next;
            fast = fast.next.next;
        }
        if(fast.next != null) {
            s.push(slow.val);
            slow = slow.next;
        }else{
             s.push(slow.val);
        }
        ListNode newH = slow;
        while(newH != null){
            if(s.pop() != newH.val){
                return false;
            }
            newH = newH.next;
        }
        return true;
    }
}