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
        if(lists.length == 0) return null;
        if(lists.length == 1) return lists[0];
        return merge(lists, 0, lists.length - 1);
    }
    public ListNode merge(ListNode[] lists, int left, int right) {
        if(left >= right) return lists[left];
        int mid = left + (right - left)/2;
        ListNode leftResult = merge(lists, left, mid);
        ListNode rightResult = merge(lists, mid+1, right);
        ListNode temp1 = leftResult;
        ListNode temp2 = rightResult;
        ListNode dummy = new ListNode(-1);
        ListNode temp3 = dummy;
        while(temp1 != null && temp2 != null) {
            if(temp1.val <= temp2.val) {
                temp3.next = temp1;
                temp3 = temp3.next;
                temp1 = temp1.next;
            } else {
                temp3.next = temp2;
                temp3 = temp3.next;
                temp2 = temp2.next;
            }
        }
        while(temp1 != null) {
            temp3.next = temp1;
            temp3 = temp3.next;
            temp1 = temp1.next;
        }
        while(temp2 != null) {
            temp3.next = temp2;
            temp3 = temp3.next;
            temp2 = temp2.next;
        }
        return dummy.next;
    }
}
