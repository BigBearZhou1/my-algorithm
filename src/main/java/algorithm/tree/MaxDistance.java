package algorithm.tree;

import algorithm.dp.Node;
import algorithm.entity.TreeNode;
import sun.applet.AppletResourceLoader;

/**
 * 二叉树的最长距离
 */
public class MaxDistance {
    class Info {
        int height;
        int maxDistance;

        public Info(int height, int maxDistance) {
            this.height = height;
            this.maxDistance = maxDistance;
        }
    }

    public int findMaxDistance(TreeNode node) {
        return process(node).maxDistance;
    }

    private Info process(TreeNode node) {
        if (node == null) {
            return new Info(0, 0);
        }
        Info leftInfo = process(node.left);
        Info rightInfo = process(node.right);

        int height = Math.max(leftInfo.height, rightInfo.height) + 1;
        int maxDistance = Math.max(Math.max(leftInfo.maxDistance, rightInfo.maxDistance),
                leftInfo.height + rightInfo.height + 1);
        return new Info(height, maxDistance);
    }
}
