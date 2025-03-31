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
        ListNode _l1 = list1;
        ListNode _l2 = list2;
        ListNode merged = new ListNode(-1);
        ListNode _merged = merged;

        while(_l1 != null && _l2 != null){
            if(_l1.val < _l2.val){
                merged.next = _l1;
                _l1 = _l1.next;
            }else{
                merged.next = _l2;
                _l2 = _l2.next;
            }

            merged = merged.next;
        }

        if(_l1 != null){
            merged.next = _l1;
        }

        if(_l2 != null){
            merged.next = _l2;
        }

        return _merged.next;
    }
}