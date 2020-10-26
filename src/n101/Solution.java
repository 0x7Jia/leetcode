package n101;

import tree.TreeNode;
import tree.TreeUtils;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).
 *
 * For example, this binary tree [1,2,2,3,4,4,3] is symmetric
 *
 * @author echo
 * @version V1.0
 * @Package n101
 * @date 2020/10/21 21:06
 */
public class Solution {
    public static boolean isSymmetric(TreeNode root) {
        if (root == null)
            return true;
        return isSymmetricHelper(root.left, root.right);
    }

    private static boolean isSymmetricHelper(TreeNode left, TreeNode right) {
        if (left == null && right == null)
            return true;

        if (left == null || right == null || left.val != right.val)
            return false;

        return isSymmetricHelper(left.left, right.right) && isSymmetricHelper(left.right, right.left);
    }

    public static void main(String[] args) {
//        TreeNode tree = TreeUtils.getTree(new Integer[]{1, 2, 2}, 0);
//        assert isSymmetric(tree);
//
//        tree = TreeUtils.getTree(new Integer[]{1,2,2,3,4,4,3}, 0);
//        assert isSymmetric(tree);

        TreeNode tree = TreeUtils.getTree(new Integer[]{1,2,2,null,3,null,3}, 0);
        System.out.println(isSymmetric(tree));
    }
}
