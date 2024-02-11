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
        ListNode l1p = l1;
        ListNode l2p = l2;
        ListNode ans = new ListNode(0);
        ListNode ansp = ans;
        int carry = 0;
        
        while(l1p != null || l2p !=null){
            int n1 = 0;
            int n2 = 0;
            if(l1p != null){
                n1 = l1p.val;
                l1p = l1p.next;
            }
            if(l2p != null){
                n2 = l2p.val;
                l2p = l2p.next;
            }
            
            int sum = n1 + n2 + carry;
            carry = 0;
            if(sum > 9){
                carry = sum/10;
                sum = sum%10;
            }
            
            ansp.next = new ListNode(sum);
            ansp = ansp.next;
        }
        
        if(carry != 0){
            ansp.next = new ListNode(carry);
        }
        return ans.next;
    }
}