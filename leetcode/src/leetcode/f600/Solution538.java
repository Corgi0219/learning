package leetcode.f600;//给定一个二叉搜索树（Binary Search Tree），把它转换成为累加树（Greater Tree)，使得每个节点的值是原来的节点值加上所有大于它的节
//点值之和。 
//
// 
//
// 例如： 
//
// 输入: 原始二叉搜索树:
//              5
//            /   \
//           2     13
//
//输出: 转换为累加树:
//             18
//            /   \
//          20     13
// 
//
// 
//
// 注意：本题和 1038: https://leetcode-cn.com/problems/binary-search-tree-to-greater-s
//um-tree/ 相同 
// Related Topics 树 
// 👍 387 👎 0


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
class Solution538 {
    public TreeNode convertBST(TreeNode root) {
        if (root == null) return null;
        helper(root);
        return root;
    }

    private int helper(TreeNode root) {
        if (root == null) return 0;

        root.val += helper(root.right);
        if (root.left != null) {
            root.left.val += root.val;
            helper(root.left);
        }
        return root.val;
    }

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(2);
        treeNode.left = new TreeNode(0);
        treeNode.right = new TreeNode(3);
        treeNode.left.left = new TreeNode(-4);
        treeNode.left.right = new TreeNode(1);
        new Solution538().convertBST(treeNode);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
