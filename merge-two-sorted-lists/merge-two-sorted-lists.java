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
//不确定头节点, 需要用到dummy节点
//dummy节点还是必须要用到，除了dummy节点外还引入一个curr节点充当下一次合并时的头节点
// 如果l2 小于 l1 节点 就把 curr.next 指向这个节点
class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null && l2 == null){
            return null;
        }else if(l1 == null){
            return l2;
        }else if(l2 == null){
            return l1;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = l1;
        ListNode curr = dummy;
        
        while(l1 != null && l2 != null){
            if(l2.val < l1.val){
                curr.next = l2;
                l2 = l2.next;
            }else{
                curr.next = l1;
                l1 = l1.next;
            }
            curr = curr.next;
        }
        //merge the list
        if(l1 != null){
            curr.next  = l1;
        }else{
            curr.next = l2;
        }
        return dummy.next;
    }
}