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
    public boolean isPalindrome(ListNode head) {
        
        if(head == null){
            return true;
        }
        
        ListNode endFirstHalf = getEndFirstHalf(head);
        ListNode startSecondHalf = reverse(endFirstHalf.next);
        
        ListNode p1 = head;
        ListNode p2 = startSecondHalf;
        boolean res = true;
        
        while(res && p2 != null){
            if(p1.val != p2.val){
                res = false;
            }
            
            p1 = p1.next;
            p2 = p2.next;
        }
        
        reverse(startSecondHalf);
        
        return res;
    }
    
    public ListNode reverse(ListNode node){
        ListNode prev = null;
        ListNode curr = node;
        
        while(curr != null){
            ListNode tmp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = tmp;
        }
        
        return prev;
        
    }
    public ListNode getEndFirstHalf(ListNode node){
        ListNode slow = node;
        ListNode fast = node;
        
        while(fast.next != null && fast.next.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        
        return slow;
    }
}