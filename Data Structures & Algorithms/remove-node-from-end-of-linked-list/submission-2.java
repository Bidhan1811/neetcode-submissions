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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode temp = head;
        int len = 0;
        while(temp != null) {
            len++;
            temp = temp.next;
        }
        if(len == n) return head.next;
        int cnt = 0;
        temp = head;
        ListNode prev = null;
        while(temp != null) {
            cnt++;
            if(cnt == (len - n + 1)) {
                ListNode next = temp.next;
                temp.next = null;
                prev.next = next;
                temp = next;
                break;
            } else {
                prev = temp;
                temp = temp.next;
            }
        }
        return head;
    }
}
