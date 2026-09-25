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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0, sum = 0;
        ListNode temp1 = l1;
        ListNode temp2 = l2;
        ListNode ans = new ListNode(-1);
        ListNode temp3 = ans;
        while(temp1 != null || temp2 != null) {
            int val1 = (temp1 == null) ? 0 : temp1.val;
            int val2 = (temp2 == null) ? 0 : temp2.val;
            int total = val1 + val2 + carry;
            sum = total % 10;
            carry = total / 10;
            ListNode s = new ListNode(sum);
            temp3.next = s;
            temp3 = temp3.next;
            temp1 = (temp1 != null) ? temp1.next : null;
            temp2 = (temp2 != null) ? temp2.next : null;
        }
        if(carry != 0) {
            ListNode c = new ListNode(carry);
            temp3.next = c;
        }
        return ans.next;
    }
    
}
