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
        ListNode t1 = list1;
        ListNode t2 = list2;
        ListNode newHead = new ListNode(-1);
        ListNode t3 = newHead;
        while(t1 != null && t2 != null) {
            if(t1.val <= t2.val) {
                ListNode temp = new ListNode(t1.val);
                t3.next = temp;
                t3 = t3.next;
                t1 = t1.next;
            }
            else {
                ListNode temp = new ListNode(t2.val);
                t3.next = temp;
                t3 = t3.next;
                t2 = t2.next;
            }
        }
        while(t1 != null) {
            ListNode temp = new ListNode(t1.val);
            t3.next = temp;
            t3 = t3.next;
            t1 = t1.next;
        }
        while(t2 != null) {
            ListNode temp = new ListNode(t2.val);
            t3.next = temp;
            t3 = t3.next;
            t2 = t2.next;
        }
        return newHead.next;
    }
}