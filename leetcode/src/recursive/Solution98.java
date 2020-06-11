package recursive;//给定一个二叉树，判断其是否是一个有效的二叉搜索树。 
//
// 假设一个二叉搜索树具有如下特征： 
//
// 
// 节点的左子树只包含小于当前节点的数。 
// 节点的右子树只包含大于当前节点的数。 
// 所有左子树和右子树自身必须也是二叉搜索树。 
// 
//
// 示例 1: 
//
// 输入:
//    2
//   / \
//  1   3
//输出: true
// 
//
// 示例 2: 
//
// 输入:
//    5
//   / \
//  1   4
//     / \
//    3   6
//输出: false
//解释: 输入为: [5,1,4,null,null,3,6]。
//     根节点的值为 5 ，但是其右子节点值为 4 。
// 
// Related Topics 树 深度优先搜索


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
class Solution98 {
    boolean isValidBST = true;

    public boolean isValidBST(TreeNode root) {
        if (root == null) return true;
        _generate(root, root.val, 0);
        return isValidBST;
    }

    private void _generate(TreeNode node, Integer rootVal, int type) {
        if (!isValidBST || node == null) {
            return;
        }
        boolean left, right;
        if (type == 1) {
            left = node.left != null && (node.left.val >= node.val || node.left.val >= rootVal);
            right = node.right != null && (node.right.val <= node.val || node.right.val >= rootVal);
        } else if (type == 2) {
            left = node.left != null && (node.left.val >= node.val || node.left.val <= rootVal);
            right = node.right != null && (node.right.val <= node.val || node.right.val <= rootVal);
        } else {
            left = node.left != null && node.left.val >= node.val;
            right = node.right != null && node.right.val <= node.val;
        }
        if (left || right) isValidBST = false;
        _generate(node.left, rootVal, 1);
        _generate(node.right, rootVal, 2);
    }

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(10);
        treeNode.left = new TreeNode(5);
        treeNode.right = new TreeNode(15);
        treeNode.right.left = new TreeNode(6);
        treeNode.right.right = new TreeNode(20);
        Solution98 solution98 = new Solution98();
        System.out.println(solution98.isValidBST(treeNode));
    }

}
