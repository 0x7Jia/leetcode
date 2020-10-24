package challenge;

/**
 * @author echo
 * @version V1.0
 * @Package challenge
 * @date 2020/10/16 23:08
 * @leetCode 74
 */
public class SearchA2DMatrix {
    public static boolean searchMatrix(int[][] matrix, int target) {
        int len = matrix.length;
        if (len == 0 || matrix[0].length == 0) return false;

        for (int i = len-1; i>=0; --i){
            if (matrix[i][0] > target)  continue;

            int innerLen = matrix[i].length;
            for (int j = 0; j<innerLen; ++j){
                if (matrix[i][j] == target)
                    return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
//        int[][] matrix = {{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 50}};
        int[][] matrix = {{}};
        int target = 13;

        System.out.println(searchMatrix(matrix, target));
    }
}
