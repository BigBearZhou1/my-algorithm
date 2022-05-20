package algorithm.tree;

import algorithm.entity.TreeNode;

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
