package tree;

/**
 * @author echo
 * @version V1.0
 * @Package tree
 * @date 2020/9/23 10:53
 */
public class TestTree {
    public static void main(String[] args) {
        TreeNode root = TreeUtils.getTree(new Integer[]{1, null, 2, null, null, null, 3}, 0);
        System.out.println(TreeUtils.getDepth(root, 0));
    }
}
