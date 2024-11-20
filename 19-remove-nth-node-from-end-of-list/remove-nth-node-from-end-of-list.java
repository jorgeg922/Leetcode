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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int count = 0;
        
        ListNode node = head;
        
        while(node != null){
            node = node.next;
            count++;
        }
        
        int targetNodeIndex = count-n;
        
        ListNode prev = null;
        ListNode curr = head;
        
        while(targetNodeIndex > 0){
            prev = curr;
            curr = curr.next;
            targetNodeIndex--;
        }
        
        if(curr == head){
            return head.next;
        }
        
        prev.next = curr.next;
        
        return head;
    }
}