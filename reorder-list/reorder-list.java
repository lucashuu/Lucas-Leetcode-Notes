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
//
class Solution {
    public void reorderList(ListNode head) {
        if(head == null || head.next == null){
            return;
        }
        ListNode slow = head;
        ListNode quick = head;
        while(quick.next != null && quick.next.next != null){
            quick = quick.next.next;
            slow = slow.next;
        }
        ListNode newHead = slow.next;
        slow.next = null;
        ListNode lp = reverse(newHead);
        ListNode lf = head;
        
        while(lp != null && lf != null){
            ListNode temp = lf.next;
            ListNode temp2 = lp.next;
            lf.next = lp;
            lp.next = temp;
            lf = temp;
            lp = temp2;
        }
        
    }
    public ListNode reverse(ListNode head){
        ListNode prev = null;
        while(head != null){
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }
}