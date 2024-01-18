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
        ListNode prev = null;
        ListNode curr = head;
        
        int nodeCount = 1;
        while(curr.next != null){
            curr = curr.next;
            nodeCount++;
        }
        
        int target = nodeCount - n;
        
        int count = 0;
        curr = head;
        while(count < target){
            prev = curr;
            curr = curr.next;
            count++;
        }
        
        if(prev == null){
            return head.next;
        }
        prev.next = curr.next;
        curr.next = null;
        
        return head;
    }
}