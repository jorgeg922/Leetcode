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
        
        StringBuilder sb = new StringBuilder();
        ListNode curr = head;
        
        while(curr != null){
            sb.append(Integer.toString(curr.val));
            curr = curr.next;
        }
        
        int left = 0;
        int right = sb.length()-1;
        
        while(left < right){
            if(sb.charAt(left) != sb.charAt(right)){
                return false;
            }
            
            left++;
            right--;
        }
        
        return true;
        
    }
}