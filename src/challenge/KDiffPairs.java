package challenge;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author echo
 * @version V1.0
 * @Package challenge
 * @date 2020/10/3 20:29
 * @leetCode 532
 */
public class KDiffPairs {
    public static int findPairs(int[] nums, int k) {
        int len = nums.length;
        if (len == 0) return 0;

        ArrayList<String> res = new ArrayList<>();
        Arrays.sort(nums);
        int count = 0;
        for (int i = 0; i<len-1; ++i){
            for (int j = i+1; j<len; ++j){
                if (nums[j] - nums[i] == k){
                    res.add(""+nums[i]+nums[j]);
                }
            }
        }
        return (int) res.stream().distinct().count();
    }

    public static void main(String[] args) {
        System.out.println(findPairs(new int[]{1,2,4,4,3,3,0,9,2,3}, 2));
        System.out.println(findPairs(new int[]{3,1,4,1,5}, 2));
        System.out.println(findPairs(new int[]{1,2,3,4,5}, 1));
        System.out.println(findPairs(new int[]{3, 1, 4, 1, 5}, 2));
        System.out.println(findPairs(new int[]{1, 1, 1, 1, 1}, 0));
        // 1 3 4 5
    }
}
