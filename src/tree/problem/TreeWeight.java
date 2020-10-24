package tree.problem;

import tree.TreeNode;
import tree.TreeUtils;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 计算带权二叉树的路径和
 *        1
 *       / \
 *      2   3
 *   out: 1+2 + 1+3 = 7
 *
 * @author echo
 * @version V1.0
 * @Package tree.problem
 * @date 2020/10/19 18:39
 */
public class TreeWeight {
    public static int sumNumbers(TreeNode root){
        if (root == null)   return -1;

        List<List<Integer>> resList = new ArrayList<>();
        dfs(root, new LinkedList<>(), resList);
        System.out.println(resList);
        return sumList(resList);
    }

    private static void dfs(TreeNode node, LinkedList<Integer> currentPath, List<List<Integer>> resList) {
        if (node!=null){
            currentPath.addLast(node.val);
        }
        if (node.left == null&&node.right == null){
            resList.add(new ArrayList<Integer>(currentPath));
            return;
        }


        if (node.left !=null){
            dfs(node.left, currentPath, resList);
            currentPath.removeLast();
        }

        if (node.right!=null){
            dfs(node.right, currentPath, resList);
            currentPath.removeLast();
        }

    }

    public static void main(String[] args) {
        TreeNode tree = TreeUtils.getTree(new Integer[]{1, 2, 3}, 0);
        System.out.println(sumNumbers(tree));

    }

    private static int sumList(List<List<Integer>> resList) {
        int sum = 0;
        for (List<Integer> li:resList){
            for (int t:li){
                sum+=t;
            }
        }

        return sum;
    }
}
