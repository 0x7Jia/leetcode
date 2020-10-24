package n965;

import tree.TreeNode;
import tree.TreeUtils;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * A binary tree is univalued if every node in the tree has the same value.
 * Return true if and only if the given tree is univalued.
 *
 * @author echo
 * @version V1.0
 * @Package n965
 * @date 2020/10/21 20:59
 */
public class Solution {
    public static boolean isUnivalTree(TreeNode root) {
        if (root == null) return true;

        int baseVal = root.val;
        Deque<TreeNode> stack = new ArrayDeque<>();
        stack.push(root);
        while (!stack.isEmpty()){
            TreeNode tempNode = stack.pop();
            if (tempNode.val != baseVal)
                return false;

            if (tempNode.left != null){
                stack.push(tempNode.left);
            }
            if (tempNode.right != null){
                stack.push(tempNode.right);
            }
        }

        return true;
    }

    public static void main(String[] args) {
        TreeNode tree = TreeUtils.getTree(new Integer[]{1, 1, 1, 1, 1, null, 1}, 0);
        System.out.println(isUnivalTree(tree));

        tree = TreeUtils.getTree(new Integer[]{2,2,2,5,2}, 0);
        System.out.println(isUnivalTree(tree));
    }
}
