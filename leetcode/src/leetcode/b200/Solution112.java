package leetcode.b200;//给定一个二叉树和一个目标和，判断该树中是否存在根节点到叶子节点的路径，这条路径上所有节点值相加等于目标和。
//
// 说明: 叶子节点是指没有子节点的节点。 
//
// 示例: 
//给定如下二叉树，以及目标和 sum = 22， 
//
//               5
//             / \
//            4   8
//           /   / \
//          11  13  4
//         /  \      \
//        7    2      1
// 
//
// 返回 true, 因为存在目标和为 22 的根节点到叶子节点的路径 5->4->11->2。 
// Related Topics 树 深度优先搜索


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
class Solution112 {
    public boolean hasPathSum(TreeNode root, int sum) {
        return isExist(root, sum, 0);
    }

    private boolean isExist(TreeNode root, int sum, int temp) {
        if (root == null) {
            return false;
        }
        temp += root.val;

        if (root.left == null && root.right == null) {
            return temp == sum;
        }
        boolean a = isExist(root.left, sum, temp);
        boolean b = isExist(root.right, sum, temp);
        return a || b;
    }

    public static void main(String[] args) {
        TreeNode node = new TreeNode(1);
//        node.left = new TreeNode(4);
//        node.left.left = new TreeNode(11);
//        node.left.left.left = new TreeNode(7);
//        node.left.left.right = new TreeNode(2);
//        node.right = new TreeNode(8);
//        node.right.left = new TreeNode(13);
//        node.right.right = new TreeNode(4);
//        node.right.right.right = new TreeNode(1);
        node.left = new TreeNode(2);
        System.out.println(new Solution112().hasPathSum(node, 1));
    }
}

class Solution112V1 {
    public boolean hasPathSum(TreeNode root, int sum) {
        return helper(root, 0, sum);
    }

    public boolean helper(TreeNode root, int cur, int sum) {
        if (root == null)
            return false;
        cur = cur + root.val;
        if (root.left == null && root.right == null) {
            return cur == sum;
        } else {
            return helper(root.left, cur, sum) || helper(root.right, cur, sum);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
