package algorithm.tree;

import algorithm.entity.TreeNode;

/**
 * 题目：958. 二叉树的完全性检验
 * 解题：
 * 1. 给每个节点设置一个位置序号
 * 2. 递归走遍整个树，记录树的大小treeSize，树里最大的序号maxSize
 * 3. 是否是完全二叉树就要看treeSize和maxSize是否一致
 */
public class IsCompleteTree958 {
    int treeSize;
    int maxSize;

    public boolean isCompleteTree(TreeNode root) {
        if (root == null) return true;
        searchTree(root, 1);
        return treeSize == maxSize;
    }

    private void searchTree(TreeNode root, int idx) {
        if (root == null) return;
        treeSize++;
        maxSize = Math.max(idx, maxSize);
        searchTree(root.left, 2 * idx);
        searchTree(root.right, 2 * idx + 1);
    }
}
