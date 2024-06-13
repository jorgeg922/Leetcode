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
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a,b)->a.val-b.val);
        
        for(ListNode list : lists){
            ListNode head = list;
            while(head != null){
                ListNode node = new ListNode(head.val);
                pq.add(node);
                head = head.next;
            }
        }
        
        ListNode ans = new ListNode(-1);
        ListNode tmp = ans;
        while(!pq.isEmpty()){
            tmp.next = pq.poll();
            tmp = tmp.next;
        }
        
        return ans.next;
    }
}