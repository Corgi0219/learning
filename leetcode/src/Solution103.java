import java.util.*;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */
class Solution103 {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Deque<TreeNode> deque = new LinkedList<>();
        boolean left2Right = true;

        deque.offer(root);
        while (!deque.isEmpty()) {
            int size = deque.size();
            Deque<Integer> list = new LinkedList<>();
            for (int i = 0; i < size; i++) {
                TreeNode node = deque.pollFirst();
                if (left2Right) {
                    list.offerLast(node.val);
                } else {
                    list.offerFirst(node.val);
                }
                if (node.left != null) {
                    deque.offerLast(node.left);
                }
                if (node.right != null) {
                    deque.offerLast(node.right);
                }
            }
            res.add(new ArrayList<>(list));
            left2Right = !left2Right;
        }
        return res;
    }
}