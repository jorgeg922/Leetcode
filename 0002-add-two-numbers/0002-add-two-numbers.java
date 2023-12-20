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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        
        ListNode l1_ptr = l1;
        ListNode l2_ptr = l2;
        ListNode ans = new ListNode(0);
        ListNode ans_ptr = ans;
        
        int carry = 0;
        while(l1_ptr != null || l2_ptr != null){
            int val1 = 0;
            int val2 = 0;
            if(l1_ptr != null){
                val1 = l1_ptr.val;
                l1_ptr = l1_ptr.next;
            }
            if(l2_ptr != null){
                val2 = l2_ptr.val;
                l2_ptr = l2_ptr.next;
            }
            
            int addition = val1 + val2 + carry;
            carry = 0;
            if(addition >= 10){
                carry = addition/10;
                addition = addition%10;
            }
            
            ans.next = new ListNode(addition);
            ans = ans.next;           
        }
        
        if(carry > 0){
            ans.next = new ListNode(carry);
        }
        
        return ans_ptr.next;
    }
}