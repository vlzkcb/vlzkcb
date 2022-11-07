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
        ListNode res = new ListNode();
        ListNode temp = res;
        if (list1 == null && list2 == null){
            return null;
        }
        while(list1 != null && list2 != null){
            if (list1.val < list2.val){
                temp.val = list1.val;
                list1 = list1.next;
            }else{
                temp.val = list2.val;
                list2 = list2.next;
            }
            temp.next = new ListNode();
            temp = temp.next;
        }
        if (list1 != null){
            while (list1 != null){
                temp.val = list1.val;
                
                list1 = list1.next;
                if (list1 != null){
                    temp.next = new ListNode();
                    temp = temp.next;    
                }
            }
        }else{
            while (list2 != null){
                temp.val = list2.val;
                
                list2 = list2.next;
                if (list2 != null){
                    temp.next = new ListNode();
                    temp = temp.next;    
                }
            }
        }
        return res;
    }
}