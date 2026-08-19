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
    public boolean hasCycle(ListNode head) {
        if (head == null) return false;

        HashSet<ListNode> visited = new HashSet<>();
        visited.add(head);
        ListNode cur = head;
        while (cur.next != null) {
            if (visited.contains(cur.next)) {
                return true;
            } else {
                visited.add(cur.next);
            }
            cur = cur.next;
        }
        return false;
    }
}
