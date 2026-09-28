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
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode prevTail = dummy;
        ListNode currHead = head;
        while(currHead != null) {
            int cnt = 0;
            ListNode temp = currHead;
            while(temp != null && cnt < k) {
                temp = temp.next;
                cnt++;
            }
            if(cnt < k) break;
            ListNode prev = temp;
            ListNode curr = currHead;
            for(int i = 0; i < k; i++) {
                ListNode next = curr.next;
                curr.next = prev;
                prev = curr;
                curr = next;
            }
            prevTail.next = prev;
            prevTail = currHead;
            currHead = temp;
        }
        return dummy.next;
    }
}
