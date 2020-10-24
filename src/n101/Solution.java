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
        String preOrderResult = preOrder(root);
        String postOrderReverseResult = postOrderRev(root);
        System.out.println(preOrderResult);
        System.out.println(postOrderReverseResult);
        return preOrderResult.equals(postOrderReverseResult);
    }

    private static String postOrderRev(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        postOrder(root, sb);
        return sb.reverse().toString();
    }

    private static void postOrder(TreeNode node, StringBuilder sb) {
        if (node == null)   return;

        postOrder(node.left, sb);
        postOrder(node.right, sb);
        sb.append(node.val);
    }

    private static String preOrder(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        Deque<TreeNode> stack = new ArrayDeque<>();
        stack.push(root);
        while (!stack.isEmpty()){
            TreeNode tempNode = stack.pop();
            sb.append(tempNode.val);
            if (tempNode.left!=null){
                stack.push(tempNode.left);
            }
            if (tempNode.right!=null){
                stack.push(tempNode.right);
            }
        }
        return sb.toString();
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
