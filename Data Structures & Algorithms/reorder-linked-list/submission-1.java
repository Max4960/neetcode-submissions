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
    public void reorderList(ListNode head) {
        ArrayList orders = new ArrayList<>();
        ListNode cur = head;
        while (cur.next != null) {
            orders.add(cur);
            cur = cur.next;
        }
        int i = 0;
        int j = orders.size() - 1;
        while (i < j) {
            orders.get(i).next() = orders.get(j);
            i++;
            if (i == j) break;
            orders.get(j).next = orders.get(i);
            j--;
        }
        orders.get(i).next = null;
    }
}
