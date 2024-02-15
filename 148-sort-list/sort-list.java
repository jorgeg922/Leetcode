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
    public ListNode sortList(ListNode head) {
       PriorityQueue<Integer> pq = new PriorityQueue<>();
        ListNode ptr = head;
        
        while(ptr != null){
            pq.add(ptr.val);
            ptr = ptr.next;
        }
        
        ListNode ans = new ListNode(-1);
        ListNode ansPtr = ans;
        
        while(!pq.isEmpty()){
            ans.next = new ListNode(pq.poll());
            ans = ans.next;
        }
        
        return ansPtr.next;
    }
}