package tree;//在上次打劫完一条街道之后和一圈房屋后，小偷又发现了一个新的可行窃的地区。这个地区只有一个入口，我们称之为“根”。 除了“根”之外，每栋房子有且只有一个“父“
//房子与之相连。一番侦察之后，聪明的小偷意识到“这个地方的所有房屋的排列类似于一棵二叉树”。 如果两个直接相连的房子在同一天晚上被打劫，房屋将自动报警。 
//
// 计算在不触动警报的情况下，小偷一晚能够盗取的最高金额。 
//
// 示例 1: 
//
// 输入: [3,2,3,null,3,null,1]
//
//     3
//    / \
//   2   3
//    \   \ 
//     3   1
//
//输出: 7 
//解释: 小偷一晚能够盗取的最高金额 = 3 + 3 + 1 = 7. 
//
// 示例 2: 
//
// 输入: [3,4,5,1,3,null,1]
//
//     3
//    / \
//   4   5
//  / \   \ 
// 1   3   1
//
//输出: 9
//解释: 小偷一晚能够盗取的最高金额 = 4 + 5 = 9.
// 
// Related Topics 树 深度优先搜索 
// 👍 464 👎 0


//leetcode submit region begin(Prohibit modification and deletion)

import java.util.HashMap;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */
class Solution337 {
    public int rob(TreeNode root) {
        int[] res = helper(root);
        return Math.max(res[0], res[1]);
    }

    private int[] helper(TreeNode root) {
        int[] ans = new int[2];
        if (root == null) return ans;
        int[] left = helper(root.left);
        int[] right = helper(root.right);
        ans[0] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        ans[1] = left[0] + right[0] + root.val;
        return ans;
    }


    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(3);
        treeNode.left = new TreeNode(4);
        treeNode.right = new TreeNode(5);
        treeNode.left.left = new TreeNode(1);
        treeNode.left.right = new TreeNode(3);
        treeNode.right.right = new TreeNode(1);

        System.out.println(new Solution337().rob(treeNode));
    }

}

class Solution337_DFS {
    public int rob(TreeNode root) {
        HashMap<TreeNode, Integer> map = new HashMap<>();
        return dfs(root, map);
    }

    public int dfs(TreeNode root, HashMap<TreeNode, Integer> map) {
        if (root == null) return 0;
        if (map.containsKey(root)) return map.get(root);
        int m = root.val;
        if (root.left != null) {
            m += dfs(root.left.left, map) + dfs(root.left.right, map);
        }
        if (root.right != null) {
            m += dfs(root.right.left, map) + dfs(root.right.right, map);
        }
        int max = Math.max(m, dfs(root.left, map) + dfs(root.right, map));
        map.put(root, max);
        return max;
    }

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(4);
        treeNode.left = new TreeNode(1);
        treeNode.left.left = new TreeNode(2);
        treeNode.left.left.left = new TreeNode(3);

        System.out.println(new Solution337_DFS().rob(treeNode));
    }
}

//leetcode submit region end(Prohibit modification and deletion)
