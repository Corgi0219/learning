package leetcode.b200;//给定一个二叉树，判断它是否是高度平衡的二叉树。
//
// 本题中，一棵高度平衡二叉树定义为： 
//
// 
// 一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过1。 
// 
//
// 示例 1: 
//
// 给定二叉树 [3,9,20,null,null,15,7] 
//
//     3
//   / \
//  9  20
//    /  \
//   15   7 
//
// 返回 true 。 
// 
//示例 2: 
//
// 给定二叉树 [1,2,2,3,3,null,null,4,4] 
//
//        1
//      / \
//     2   2
//    / \
//   3   3
//  / \
// 4   4
// 
//
// 返回 false 。 
//
// 
// Related Topics 树 深度优先搜索 
// 👍 427 👎 0


//leetcode submit region begin(Prohibit modification and deletion)

import leetcode.TreeNode;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */
class Solution110 {
    public boolean isBalanced(TreeNode root) {
        int left = dfs(root.left, 0);
        int right = dfs(root.right, 0);
        return left - right > 1 || right - left > 1;
    }

    private int dfs(TreeNode root, int level) {
        if (root == null) return level;
        level += 1;
        int left = dfs(root.left, level);
        int right = dfs(root.right, level);
        return Math.max(left, right);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
