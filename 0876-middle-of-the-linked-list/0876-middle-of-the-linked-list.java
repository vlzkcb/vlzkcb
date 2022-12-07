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
    public ListNode middleNode(ListNode head) {
        ListNode doub = head;
        ListNode sing = head;
        while (doub != null && doub.next != null){
            doub = doub.next.next;
            sing = sing.next;
        }
        return sing;
    }
}