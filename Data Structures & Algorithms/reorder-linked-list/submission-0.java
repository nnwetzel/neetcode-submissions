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
        ListNode slow = head;
        ListNode fast = head.next;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode second = slow.next;
        ListNode prev = slow.next = null;

        // Reverse second half of list
        while (second != null) {
            ListNode temp = second.next;
            second.next = prev;

            prev = second;
            second = temp;
        }

        // So second half is reversed: 2, 4 and 8, 6

        ListNode first = head; // first = 2 (-> 4)
        second = prev; // second = 8 (-> 6)

        while (second != null) {
            // We need to save the next value in the list
            // This is because we are overriding it with the
            // next value. But they need to be added eventually
            ListNode temp1 = first.next; // temp1 = 4
            ListNode temp2 = second.next; // temp2 = 6
            first.next = second; // 2 -> 8
            second.next = temp1; // (2 ->) 8 -> 4
            first = temp1; // first = 4
            second = temp2; // second = 6
        }
    }
}
