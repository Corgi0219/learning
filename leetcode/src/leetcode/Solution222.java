package leetcode;

import java.util.Deque;
import java.util.LinkedList;

class Solution222 {
    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }

        Deque<TreeNode> deque = new LinkedList<>();
        deque.offer(root);
        int count = 1;
        while (!deque.isEmpty()) {
            TreeNode node = deque.pollFirst();
            if (node.left != null && node.right != null) {
                count += 2;
                deque.offer(node.left);
                deque.offer(node.right);
            } else if (node.left != null) {
                count++;
            }
        }
        return count;
    }
}

class Solution222_1 {
    private int count;

    public int countNodes(TreeNode root) {
        if (root == null) {
            return count;
        }
        count++;
        countNodes(root.left);
        countNodes(root.right);
        return count;
    }
}