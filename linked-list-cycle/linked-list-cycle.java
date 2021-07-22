/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
//快慢指针
public class Solution {
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        ListNode q = head;
        ListNode s = head;
        while(q.next != null && q.next.next != null){
                q = q.next.next;
                s = s.next;
            if(q == s){
                return true;
            }
        }
        return false;
    }
}