package tree;

/**
 * @author echo
 * @version V1.0
 * @Package tree
 * @date 2020/9/19 21:48
 */
public class TreeUtils {
    /**
     * @param arr 先序遍历的数组
     * @param index 开始位置下标
     * @return tree
     */
    public static TreeNode getTree(Integer[] arr, int index){
        TreeNode node = null;
        if (index<arr.length && arr[index]!=null){
            node = new TreeNode(arr[index]);
            node.left = getTree(arr, 2*index+1);
            node.right = getTree(arr, 2*index+2);
        }

        return node;
    }

    public static int getDepth(TreeNode node, int n){
        if (node == null){
            return n;
        }

        return Math.max(getDepth(node.left, n+1), getDepth(node.right, n+1));
    }
}

