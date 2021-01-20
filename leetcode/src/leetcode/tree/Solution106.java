package leetcode.tree;//根据一棵树的中序遍历与后序遍历构造二叉树。
//
// 注意: 
//你可以假设树中没有重复的元素。 
//
// 例如，给出 
//
// 中序遍历 inorder = [9,3,15,20,7]
//后序遍历 postorder = [9,15,7,20,3] 
//
// 返回如下的二叉树： 
//
//     3
//   / \
//  9  20
//    /  \
//   15   7
// 
// Related Topics 树 深度优先搜索 数组 
// 👍 359 👎 0


//leetcode submit region begin(Prohibit modification and deletion)

import java.util.HashMap;
import java.util.Map;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */
class Solution106 {
    private Map<Integer, Integer> inorderMap;
    private int[] postorder;

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        inorderMap = new HashMap<>(inorder.length);
        this.postorder = postorder;
        for (int i = 0; i < inorder.length; i++) {
            inorderMap.put(inorder[i], i);
        }
        return helper(0, inorder.length - 1, 0, postorder.length - 1);
    }

    private TreeNode helper(int is, int ie, int ps, int pe) {
        if (is > ie || ps > ie) return null;

        int rootVal = postorder[pe];
        Integer rootIdx = inorderMap.get(rootVal);

        TreeNode node = new TreeNode(rootVal);
        node.left = helper(is, rootIdx - 1, ps, ps + rootIdx - is - 1);
        node.right = helper(rootIdx + 1, ie, ps + rootIdx - is, pe);
        return node;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
