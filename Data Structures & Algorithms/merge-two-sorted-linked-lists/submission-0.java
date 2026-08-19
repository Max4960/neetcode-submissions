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
        ListNode cur1 = list1;
        ListNode cur2 = list2;
        ListNode head = new ListNode(-101);
        ListNode curr = head;

        while (cur1 != null && cur2 != null) {
            if (cur1.val <= cur2.val) {
                curr.next = cur1;
                cur1 = cur1.next;
            } else {
                curr.next = cur2;
                cur2 = cur2.next;
            }
            curr = curr.next;
        }
        if (cur1 != null) {
            curr.next = cur1;
        }
        if (cur2 != null) {
            curr.next = cur2;
        }

        return head.next;
    }
}