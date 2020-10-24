package challenge;

import java.util.Arrays;

/**
 * @author echo
 * @version V1.0
 * @Package challenge
 * @date 2020/9/25 13:33
 * @leetCode 389
 * Given two strings s and t which consist of only lowercase letters.
 *
 * String t is generated by random shuffling string s and then add one more letter at a random position.
 *
 * Find the letter that was added in t.
 */
public class FindDifferent {
    public static char findTheDifference(String s, String t) {
        char[] sCharArray = s.toCharArray();
        char[] tCharArray = t.toCharArray();

        Arrays.sort(sCharArray);
        Arrays.sort(tCharArray);

        int i = -1;
        while (++i < sCharArray.length){
            if (sCharArray[i] != tCharArray[i]){
                break;
            }
        }

        return tCharArray[i];
    }

    public static void main(String[] args) {
        System.out.println(findTheDifference("avf", "bavf"));
    }
}
