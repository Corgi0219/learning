package leetcode.a1_100;

import leetcode.ListNode;

import java.util.List;
import java.util.Stack;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution19 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head.next == null) {
            return head;
        }

        ListNode dummy = head;
        int count = 0;
        while (head != null) {
            head = head.next;
            count++;
        }
        int index = count - n + 1;
        head = dummy;
        count = 1;
        ListNode pre = null;
        while (count <= index) {
            if (count == index) {
                pre.next = head.next;
            }
            pre = head;
            head = head.next;
            count++;
        }
        return dummy;

    }
}