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
    public ListNode reverseList(ListNode head) {
        ListNode start = head;
        ListNode pll = null;
        ListNode nll = null;
        while (head != null){
            pll = nll;
            nll = new ListNode(head.val, pll);
            head = head.next;
        }
        return nll;
    }
}