package n1;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author echo
 * @version V1.0
 * @Package n1
 * @date 2020/9/25 13:14
 */
public class Solution {
    /**
     *
     * @param nums
     * @param target
     * @return
     * @Tn: O(n^2)
     * @Sn: O(1)
     */
    public static int[] twoSum(int[] nums, int target) {
        int len = nums.length;
        int[] res = new int[2];
        for (int i = 0; i < len-1; ++i){
            for (int j = i+1; j < len; ++j){
                if (nums[i] + nums[j] == target){
                    res[0] = i;
                    res[1] = j;
                    return res;
                }
            }
        }

        return res;
    }

    public static void main(String[] args) {
        Arrays.stream(twoSum(new int[]{2, 7, 11, 15}, 9)).forEach((t)-> System.out.print(t+" "));
        Arrays.stream(twoSum(new int[]{3, 2, 4}, 6)).forEach((t)-> System.out.print(t+" "));
        Arrays.stream(twoSum(new int[]{3, 3}, 6)).forEach((t)-> System.out.print(t+" "));
    }
}
