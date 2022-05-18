package algorithm.tree;

import algorithm.entity.TreeNode;

import java.util.Stack;

public class FlattenTree114 {
    public void flatten(TreeNode root) {
        if (root == null) return;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        TreeNode prev = null;
        TreeNode cur = null;

        while (!stack.isEmpty()) {
            cur = stack.pop();
            if (prev != null) {
                prev.left = null;
                prev.right = cur;
            }
            TreeNode left = cur.left;
            TreeNode right = cur.right;

            if (right != null) {
                stack.push(right);
            }

            if (left != null) {
                stack.push(left);
            }
            prev = cur;
        }
    }
}
