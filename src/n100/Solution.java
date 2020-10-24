package n100;

import tree.TreeNode;
import tree.TreeUtils;


/**
 * @author echo
 * @version V1.0
 * @Package n100
 * @date 2020/10/24 11:50
 * @leetCode 100
 */
public class Solution {
    public static boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null){
            return true;
        }

        if (p == null || q == null || p.val != q.val){
            return false;
        }

        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }

    public static void main(String[] args) {
        TreeNode t1 = TreeUtils.getTree(new Integer[]{1, 2}, 0);
        TreeNode t2 = TreeUtils.getTree(new Integer[]{1, null, 2}, 0);

        System.out.println(isSameTree(t1, t2));
    }
}
