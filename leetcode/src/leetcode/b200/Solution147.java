package leetcode.b200;

import leetcode.ListNode;

class Solution147 {
    public ListNode insertionSortList(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;

        ListNode curr = head.next, lastSorted = head;
        while (curr != null) {
            if (curr.val < lastSorted.val) {
                ListNode prev = dummyHead;
                while (prev.next.val <= curr.val) {
                    prev = prev.next;
                }
                lastSorted.next = curr.next;
                curr.next = prev.next;
                prev.next = curr;
            } else {
                lastSorted = lastSorted.next;
            }
            curr = lastSorted.next;
        }
        return dummyHead.next;
    }
}