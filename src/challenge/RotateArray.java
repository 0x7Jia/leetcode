package challenge;

import java.util.Arrays;

/**
 * @author echo
 * @version V1.0
 * @Package challenge
 * @date 2020/10/16 23:24
 * @leetCode 189
 */
public class RotateArray {
    public static void rotate(int[] nums, int k) {
        int len = nums.length;
        while (k>len){
            k -= len;
        }

        int[] temp = new int[k];
        System.arraycopy(nums, len-k, temp, 0, k);
        System.arraycopy(nums, 0, nums, k, len-k);
        System.arraycopy(temp, 0, nums, 0, k);
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5};
        int k = 1;
//        rotate(nums, 1);
//        rotate(nums, 2);
//        rotate(nums, 3);
//        rotate(nums, 4);
//        rotate(nums, 5);
        rotate(nums, 6);
//        rotate(nums, 7);

        Arrays.stream(nums).forEach(System.out::print);

    }
}
