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
    public void reorderList(ListNode head) {
        ListNode curr = head;
        
        while(curr.next != null){
            ListNode tail = curr;
            ListNode tail_prev = null;
            
            while(tail.next != null){
                tail_prev = tail;
                tail = tail.next;
            }
            
            if(tail_prev == curr){
                break;
            }
            
            ListNode tmp = curr.next;
            curr.next = tail;
            tail.next = tmp;
            tail_prev.next = null;
            curr = tmp;
        }
    }
}