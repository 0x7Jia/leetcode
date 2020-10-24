package challenge;

import java.util.*;

/**
 * @author echo
 * @version V1.0
 * @Package challenge
 * @date 2020/9/26 14:07
 * @leetCode 179
 * Given a list of non negative integers, arrange them such that they form the largest number.
 * Input: [3,30,34,5,9]
 * Output: "9534330"
 */
public class LargestNumber {
    public static String largestNumber(int[] nums) {
        String[] sArr = new String[nums.length];
        for (int i = 0; i<nums.length; ++i){
            sArr[i] = String.valueOf(nums[i]);
        }

        Arrays.sort(sArr, (o1, o2) -> {
            String s1 = o1+o2;
            String s2 = o2+o1;
            return s2.compareTo(s1);
        });

        StringBuilder sb = new StringBuilder();
        Arrays.stream(sArr).forEach(sb::append);
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(largestNumber(new int[]{3, 30, 34, 5, 9}));
        System.out.println(largestNumber(new int[]{10, 2}));
        System.out.println(largestNumber(new int[]{9, 89, 789, 6789}));
        System.out.println(largestNumber(new int[]{121, 12}));
        System.out.println(largestNumber(new int[]{9, 98}));
        System.out.println(largestNumber(new int[]{0, 0}));
    }

}
