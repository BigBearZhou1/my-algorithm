package algorithm.tree;

import algorithm.entity.TreeNode;

/**
 * 题目：110. 平衡二叉树
 * 解题思路：
 * 1. 递归左右字树
 * 2. 记录左右子树的高度和是否是平衡树
 * 3. 本节点的两颗子树要判断高度是否相差小于1
 */
public class IsBalancedTree110 {
    class BackInfo {
        int size;
        boolean isBalanced;

        public BackInfo(int size, boolean isBalanced) {
            this.size = size;
            this.isBalanced = isBalanced;
        }
    }

    public boolean isBalanced(TreeNode root) {
        BackInfo backInfo = isBalancedRecur(root);
        return backInfo.isBalanced;
    }

    private BackInfo isBalancedRecur(TreeNode root) {
        if (root == null) {
            return new BackInfo(0, true);
        }
        BackInfo leftInfo = isBalancedRecur(root.left);
        BackInfo rightInfo = isBalancedRecur(root.right);

        if (leftInfo.isBalanced && rightInfo.isBalanced && Math.abs(leftInfo.size - rightInfo.size) <= 1) {
            return new BackInfo(1 + Math.max(leftInfo.size, rightInfo.size), true);
        }
        return new BackInfo(0, false);
    }
}
