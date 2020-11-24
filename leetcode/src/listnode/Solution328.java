package listnode;

class Solution328 {
    public ListNode oddEvenList(ListNode head) {
        ListNode h1 = head;
        ListNode h2 = head.next;
        ListNode oushu = head;
        ListNode jishu = head.next;
        int index = 0;
        while (jishu != null) {
            if ((index++ & 1) > 0) {
//                奇数
                jishu.next = oushu.next;
                jishu = jishu.next;
                if (jishu == null) {
                    oushu.next = h2;
                }
            } else {
//                偶数
                oushu.next = jishu.next;
                if (oushu.next == null) {
                    oushu.next = h2;
                    break;
                }
                oushu = oushu.next;
            }
        }
        return h1;
    }

    public ListNode oddEvenList1(ListNode head) {
        if (head == null) return head;

        ListNode jishuHead = head.next;
        ListNode oushu = head, jishu = jishuHead;

        while (jishu != null && jishu.next != null) {
            oushu.next = jishu.next;
            oushu = oushu.next;
            jishu.next = oushu.next;
            jishu = jishu.next;
        }
        oushu.next = jishuHead;
        return head;
    }

    public static void main(String[] args) {
//        new Solution().oddEvenList(new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5,new ListNode(6)))))));
        new Solution328().oddEvenList(new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5))))));
    }
}