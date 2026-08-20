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

        if (length == 2) {
            if (n == 2) {
                return head.next;
            } else {
                head.next = null;
                return head;
            }
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
        if (prev != null) prev.next = cur.next;
        cur = null;
        return head;
    }
}
