package algorithm.tree;

import algorithm.entity.TreeNode;

public class IsFullTree {
    class Info {
        int height;
        int size;

        public Info(int height, int size) {
            this.height = height;
            this.size = size;
        }
    }

    public boolean isFullTree(TreeNode root) {
        Info info = doCheckFullTree(root);
        return (1 << info.height) - 1 == info.size;
    }

    private Info doCheckFullTree(TreeNode root) {
        if (root == null) {
            return new Info(0, 0);
        }
        Info leftInfo = doCheckFullTree(root.left);
        Info rightInfo = doCheckFullTree(root.right);

        int height = Math.max(leftInfo.height, rightInfo.height) + 1;
        int size = leftInfo.size + rightInfo.size + 1;
        return new Info(height, size);
    }
}
