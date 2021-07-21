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
    public ListNode deleteDuplicatesUnsorted(ListNode head) {
        if(head == null || head.next == null){
            return head;    
        }
        HashMap<Integer, Boolean> map = new HashMap<>();
        ListNode p = new ListNode(0);
        ListNode w = new ListNode(0);
        p.next = head;
        w.next = head;
        while (p != null && p.next != null){
            if(map.containsKey(p.next.val)){
                map.put(p.next.val, false);
                if(map.containsKey(p.next.next)){
                    p.next = p.next.next.next;
                }else{
                    p.next = p.next.next;
                }
            }else{
                map.put(p.next.val, true);
                p = p.next;
               
            }
        }
        ListNode ww = w;
        while (w != null && w.next != null){
            
            if(!map.get(w.next.val)){
                System.out.println(1);
                w.next = w.next.next;
            }else{
                w = w.next;
            }
        }
       
        
        return ww.next;
    }
}