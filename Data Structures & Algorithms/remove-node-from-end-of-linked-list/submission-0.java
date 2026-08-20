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
        if (head.next == null) {
            return null;
        }

        int length = 1;
        ListNode cur = head;
        while (cur.next != null) {
            length++;
            cur = cur.next;
        }

        cur = head;
        ListNode prev = null;
        for (int i = length; i >= 0; i--) {
            if (i == n) {
                break;

            }
            prev = cur;
            cur = cur.next;
        }

        prev.next = cur.next;
        cur = null;
        return head;
    }
}
