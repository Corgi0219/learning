package leetcode.j901_1000;//给定一个二叉树，我们在树的节点上安装摄像头。
//
// 节点上的每个摄影头都可以监视其父对象、自身及其直接子对象。 
//
// 计算监控树的所有节点所需的最小摄像头数量。 
//
// 
//
// 示例 1： 
//
// 
//
// 输入：[0,0,null,0,0]
//输出：1
//解释：如图所示，一台摄像头足以监控所有节点。
// 
//
// 示例 2： 
//
// 
//
// 输入：[0,0,null,0,null,0,null,null,0]
//输出：2
//解释：需要至少两个摄像头来监视树的所有节点。 上图显示了摄像头放置的有效位置之一。
// 
//
// 
//提示： 
//
// 
// 给定树的节点数的范围是 [1, 1000]。 
// 每个节点的值都是 0。 
// 
// Related Topics 树 深度优先搜索 动态规划 
// 👍 201 👎 0


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
class Solution968 {
    public int minCameraCover(TreeNode root) {
        int[] arr = dfs(root);
        return arr[1];
    }

    private int[] dfs(TreeNode root) {
        if (root == null) {
            return new int[]{Integer.MAX_VALUE / 2, 0, 0};
        }

        int[] leftArr = dfs(root.left);
        int[] rightArr = dfs(root.right);
        int[] arr = new int[3];
        arr[0] = leftArr[2] + rightArr[2] + 1;
        arr[1] = Math.min(arr[0], Math.min(leftArr[0] + rightArr[1], leftArr[1] + rightArr[0]));
        arr[2] = Math.min(arr[0], leftArr[1] + rightArr[1]);
        return arr;
    }

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(2);
        treeNode.left = new TreeNode(0);
        treeNode.right = new TreeNode(3);
        new Solution968().minCameraCover(treeNode);
    }

}
//leetcode submit region end(Prohibit modification and deletion)
