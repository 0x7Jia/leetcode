package n404;

import tree.TreeNode;
import tree.TreeUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @author echo
 * @version V1.0
 * @Package n404
 * @date 2020/9/19 21:42
 */
public class Solution {
    public static int sumOfLeftLeaves(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<>();
        getLeftLeaves(root, res, false);

        int sum = 0;
        for (int item:res){
            sum+=item;
        }
        return sum;
    }

    public static void getLeftLeaves(TreeNode t, List<Integer> leftList, boolean isleft){
        if(t==null) return;

        if(t.left==null && t.right==null && isleft){
            leftList.add(t.val);
        }
        getLeftLeaves(t.left, leftList, true);
        getLeftLeaves(t.right, leftList, false);
    }

    public static void main(String[] args) {
        TreeNode root = TreeUtils.getTree(new Integer[]{1}, 0);
        int sum = sumOfLeftLeaves(root);
        System.out.println(sum);
    }
}
