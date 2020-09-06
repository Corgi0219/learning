//给定一个二叉树，原地将它展开为一个单链表。 
//
// 
//
// 例如，给定二叉树 
//
//     1
//   / \
//  2   5
// / \   \
//3   4   6 
//
// 将其展开为： 
//
// 1
// \
//  2
//   \
//    3
//     \
//      4
//       \
//        5
//         \
//          6 
// Related Topics 树 深度优先搜索 
// 👍 467 👎 0


//leetcode submit region begin(Prohibit modification and deletion)


import java.util.ArrayList;
import java.util.Stack;

class Solution114 {

    public void flatten(TreeNode root) {
        while (root != null) {
            if (root.left != null) {
                TreeNode pre = root.left;
                while (pre.right != null) pre = pre.right;
                pre.right = root.right;
                root.right = root.left;
                root.left = null;
            }
            root = root.right;
        }
    }

    /**
     * 巧妙利用后序遍历
     */
    static class Solution1 {
        private TreeNode pre = null;

        public void flatten(TreeNode root) {
            if (root == null) return;
            flatten(root.right);
            flatten(root.left);
            root.right = pre;
            root.left = null;
            pre = root;
        }
    }

    /**
     * 先序遍历 + 栈
     */
    static class Solution2 {
        private TreeNode pre = null;

        public void flatten(TreeNode root) {
            if (root == null) return;
            Stack<TreeNode> stack = new Stack<>();
            stack.push(root);
            while (!stack.isEmpty()) {
                TreeNode pop = stack.pop();
                if (pre != null) {
                    pre.right = pop;
                    pre.left = null;
                }

                if (pop.right != null) {
                    stack.push(pop.right);
                }
                if (pop.left != null) {
                    stack.push(pop.left);
                }
                pre = pop;
            }
        }
    }

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1);
        treeNode.left = new TreeNode(2);
        treeNode.left.left = new TreeNode(3);
        treeNode.left.right = new TreeNode(4);
        treeNode.right = new TreeNode(5);
        treeNode.right.right = new TreeNode(6);
        new Solution1().flatten(treeNode);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
