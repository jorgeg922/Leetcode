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
        if(lists.length == 0){
            return null;
        }
        ListNode node = lists[0];
        
        for(int i=1; i<lists.length; i++){
            ListNode currList = lists[i];
            node = sort(node, currList);
        }
        
        return node;
    }
    
    public ListNode sort(ListNode nodeA, ListNode nodeB){
        ListNode tmp = new ListNode(-1);
        ListNode ans = tmp;
        
        while(nodeA != null && nodeB != null){
            if(nodeA.val < nodeB.val){
                tmp.next = nodeA;
                nodeA = nodeA.next;
            }else{
                tmp.next = nodeB;
                nodeB = nodeB.next;
            }
            tmp = tmp.next;
        }
        
        if(nodeA != null){
            tmp.next = nodeA;
        }
        
        if(nodeB != null){
            tmp.next = nodeB;
        }
        
        return ans.next;
        
    }
}