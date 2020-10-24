package n563;

import tree.TreeNode;
import tree.TreeUtils;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.Stack;

/**
 *            1
 *          /  \
 *         2    3
 *       /  \  / \
 *      4   5 6  7
 *     / \  /
 *    8  9 10
 * @author echo
 * @version V1.0
 * @Package n563
 * @date 2020/10/20 23:41
 */
public class Solution {
    public static int findTilt(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<>();
        traverse(root, res);
        return res.stream().mapToInt(Integer::intValue).sum();
    }

    private static void traverse(TreeNode node, ArrayList<Integer> res) {
        if (node == null)
            return;

        int left = treeSum(node.left);
        int right = treeSum(node.right);
        res.add(Math.abs(left - right));

        traverse(node.left, res);
        traverse(node.right, res);
    }

    private static int treeSum(TreeNode node) {
        if (node == null) return 0;

        Deque<TreeNode> stack = new ArrayDeque<>();
        int sum = 0;
        stack.push(node);
        while (!stack.isEmpty()){
            TreeNode tempNode = stack.pop();
            sum += tempNode.val;
            if (tempNode.left!=null){
                stack.push(tempNode.left);
            }
            if (tempNode.right!=null){
                stack.push(tempNode.right);
            }
        }

        return sum;
    }

    public static void main(String[] args) {
        System.out.println(findTilt(TreeUtils.getTree(new Integer[]{1,2,3,4,5,6,7,8,9,10}, 0)));
    }
}
