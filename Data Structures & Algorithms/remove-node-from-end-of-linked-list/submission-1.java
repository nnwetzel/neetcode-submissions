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
        // dummy -> 1, 2  4 -> null
        //             l          r

        // 1. Initialize right and left pointer to point at dummy and head, respectively.
        ListNode dummy = new ListNode (0, head);
        ListNode left = dummy;
        ListNode right = head;
        // 2. Move right pointer n + 1 steps ahead of the left pointer. n + 1 steps because we need to remove the pointer at n, and that can be done at n - 1.
        while (n > 0) {
            right = right.next;
            n--;
        }
        // 3. Move right and left pointer until right pointer reaches the end of the list or null.
        while (right != null) {
            right = right.next;
            left = left.next;
        }
        // 4. Set the n - 1 node to point to the node at n + 1, removing the nth node from the end of the list.
        left.next = left.next.next;
        // 5. Return the head of the list (excluding dummy), so just return dummy.next.
        return dummy.next;
    }
}
