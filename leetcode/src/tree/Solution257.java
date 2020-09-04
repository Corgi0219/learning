package tree;//给定一个二叉树，返回所有从根节点到叶子节点的路径。
//
// 说明: 叶子节点是指没有子节点的节点。 
//
// 示例: 
//
// 输入:
//
//   1
// /   \
//2     3
// \
//  5
//
//输出: ["1->2->5", "1->3"]
//
//解释: 所有根节点到叶子节点的路径为: 1->2->5, 1->3 
// Related Topics 树 深度优先搜索 
// 👍 324 👎 0


//leetcode submit region begin(Prohibit modification and deletion)

import java.util.ArrayList;
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
class Solution257 {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>();
        if (root == null) return res;
        dfs(root, root.val + "", res);
        return res;
    }

    private void dfs(TreeNode node, String path, List<String> res) {
        String nextPath = path;
        if (node.right == null && node.left == null) {
            res.add(path);
            return;
        }
        nextPath += "->";

        if (node.left != null) dfs(node.left, nextPath + node.left.val, res);
        if (node.right != null) dfs(node.right, nextPath + node.right.val, res);
    }
}

class Solution257_1 {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>();
        if (root == null) return res;
        dfs(root, new StringBuilder(), res);
        return res;
    }

    private void dfs(TreeNode node, StringBuilder path, List<String> res) {
        if (node.left == null && node.right == null) {
            res.add(path.append(node.val).toString());
        } else {
            int oldLen = path.length();
            path.append(node.val).append("->");
            if (node.left != null) dfs(node.left, path, res);
            if (node.right != null) dfs(node.right, path, res);
            path.delete(oldLen, path.length());
        }
    }

    public static void main(String[] args) {
        TreeNode node = new TreeNode(1);
        node.left = new TreeNode(2);
        node.right = new TreeNode(3);
        new Solution257_1().binaryTreePaths(node);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
