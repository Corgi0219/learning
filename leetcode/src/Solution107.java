//给定一个二叉树，返回其节点值自底向上的层次遍历。 （即按从叶子节点所在层到根节点所在的层，逐层从左向右遍历） 
//
// 例如： 
//给定二叉树 [3,9,20,null,null,15,7], 
//
//     3
//   / \
//  9  20
//    /  \
//   15   7
// 
//
// 返回其自底向上的层次遍历为： 
//
// [
//  [15,7],
//  [9,20],
//  [3]
//]
// 
// Related Topics 树 广度优先搜索 
// 👍 316 👎 0


//leetcode submit region begin(Prohibit modification and deletion)

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */
class Solution107 {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;

        ArrayDeque<TreeNode> deque = new ArrayDeque<>();
        deque.offer(root);
        while (!deque.isEmpty()) {
            int size = deque.size();
            ArrayList<Integer> list = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode node = deque.pollFirst();
                list.add(node.val);
                if (node.left != null) deque.offer(node.left);
                if (node.right != null) deque.offer(node.right);
            }
            res.add(list);
        }
        Collections.reverse(res);
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
