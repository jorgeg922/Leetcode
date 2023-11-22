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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode newHead = new ListNode(0);
        ListNode tmp = newHead;
        
        ListNode l1 = list1;
        ListNode l2 = list2;
        
        while(l1 != null && l2 != null){
            if(l1.val < l2.val){
                tmp.next = l1;
                l1 = l1.next;
            }else{
                tmp.next = l2;
                l2 = l2.next;
            }
            
            tmp = tmp.next;
        }
        
        if(l1 != null){
            while(l1 != null){
                tmp.next = l1;
                l1 = l1.next;
                tmp = tmp.next;
            }
        }
        
        if(l2 != null){
            while(l2 != null){
                tmp.next = l2;
                l2 = l2.next;
                tmp = tmp.next;
            }
        }
        
        return newHead.next;
    }
}