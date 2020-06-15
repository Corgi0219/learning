package recursive;//给定一个二叉树，找出其最大深度。
//
// 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。 
//
// 说明: 叶子节点是指没有子节点的节点。 
//
// 示例： 
//给定二叉树 [3,9,20,null,null,15,7]， 
//
//     3
//   / \
//  9  20
//    /  \
//   15   7 
//
// 返回它的最大深度 3 。 
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
class Solution104 {
    int depth = 0;

    public int maxDepth(TreeNode root) {
        countDepth(root, 0);
        return depth;
    }

    private void countDepth(TreeNode root, int tempDepth) {
        if (root == null) {
            depth = Math.max(depth, tempDepth);
            return;
        }
        countDepth(root.left, tempDepth + 1);
        countDepth(root.right, tempDepth + 1);
    }

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(10);
        treeNode.left = new TreeNode(5);
        treeNode.right = new TreeNode(15);
        treeNode.right.left = new TreeNode(6);
        treeNode.right.right = new TreeNode(20);

        Solution104 solution104 = new Solution104();
        System.out.println(solution104.maxDepth(treeNode));
    }
}

class Solution104_1 {
    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        return Math.max(left, right) + 1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
