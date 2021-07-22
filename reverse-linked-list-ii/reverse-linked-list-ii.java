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
class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {
       ListNode dummy = new ListNode(0);
        dummy.next = head;

        // find the mth node
        ListNode premNode = dummy;
        for (int i = 1; i < left; i++) {
            premNode = premNode.next;
        }
        System.out.println(premNode.val);
        // reverse node between m and n
        ListNode prev = null, curr = premNode.next;
        while (curr != null && (left <= right)) {
            ListNode nextNode = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextNode;
            left++;
        }
        System.out.println(prev.val);
        // join head and tail before m and after n
       
        premNode.next.next = curr;
        premNode.next = prev;
        return dummy.next;
    }
}