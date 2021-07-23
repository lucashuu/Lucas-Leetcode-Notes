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
//画图 寻找规律 
// 迭代法
class Solution {
    public ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode cur = head;
        ListNode prev = dummy;
        ListNode after = null;
        while(cur != null && cur.next != null){
            after = cur.next;
            ListNode nextCur = after.next;
            after.next = cur;
            prev.next = after;
            cur.next = nextCur;
            prev = cur;
            cur = nextCur;
        }
        return dummy.next;
    }
}