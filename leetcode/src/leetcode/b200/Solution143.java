package leetcode.b200;


import leetcode.listnode.ListNode;

import java.util.ArrayDeque;

class Solution143 {
    public void reorderList(ListNode head) {
        int count = 0;
        ArrayDeque<ListNode> deque = new ArrayDeque<>();
        while (head != null) {
            deque.offer(head);
            head = head.next;
            count++;
        }
        head = deque.peekFirst();
        int i = 0, listCount = count;
        count >>= 1;
        while (i < count) {
            ListNode first = deque.pollFirst();
            ListNode last = deque.pollLast();
            if (first != null && last != null) {
                first.next = last;
                if (i == count - 1) {
                    if (listCount % 2 == 0) {
                        last.next = null;
                    } else {
                        last.next = deque.peekFirst();
                        deque.peekFirst().next = null;
                    }
                } else {
                    last.next = deque.peekFirst();
                }
            }
            i++;
        }
    }

    public static void main(String[] args) {
//        ListNode node = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5, new ListNode(6))))));
        ListNode node = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, null))));
        new Solution143().reorderList(node);
    }
}
