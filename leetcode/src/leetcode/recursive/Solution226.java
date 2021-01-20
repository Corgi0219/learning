package leetcode.recursive;//翻转一棵二叉树。
//
// 示例： 
//
// 输入： 
//
//      4
//   /   \
//  2     7
// / \   / \
//1   3 6   9 
//
// 输出： 
//
//      4
//   /   \
//  7     2
// / \   / \
//9   6 3   1 
//
// 备注: 
//这个问题是受到 Max Howell 的 原问题 启发的 ： 
//
// 谷歌：我们90％的工程师使用您编写的软件(Homebrew)，但是您却无法在面试时在白板上写出翻转二叉树这道题，这太糟糕了。 
// Related Topics 树


//leetcode submit region begin(Prohibit modification and deletion)

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

public class Solution226 {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) return null;
        inverse(root);
        return root;
    }

    private void inverse(TreeNode node) {
        if (node == null) {
            return;
        }

        TreeNode tempNode = node.left;
        node.left = node.right;
        node.right = tempNode;

        inverse(node.left);
        inverse(node.right);
    }

    public static void main(String[] args) {
        Solution226 solution226 = new Solution226();
        TreeNode node = new TreeNode(4);
        node.left = new TreeNode(2);
        node.left.left = new TreeNode(1);
        node.left.right = new TreeNode(3);

        node.right = new TreeNode(7);
        node.right.left = new TreeNode(6);
        node.right.right = new TreeNode(9);
        TreeNode tree = solution226.invertTree(node);
        System.out.println(tree);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
