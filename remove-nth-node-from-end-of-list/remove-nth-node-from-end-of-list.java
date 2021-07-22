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
//找倒数第几个元素 可以用 快慢指针
//快指针 先走 n个格 还剩 length - n
//满指针 走lenth - n 还剩N 则到了第n个元素
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
     if(head == null){
         return head;
     }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
     
        ListNode q = dummy;
        ListNode slow = dummy;
        for(int i = 0; i < n; i++){
            q = q.next;
        }
         while(q.next != null){
         q = q.next;
         slow = slow.next;
         }
         slow.next = slow.next.next;
       
         return dummy.next;
    }
}