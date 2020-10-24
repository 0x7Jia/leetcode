package challenge;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

/**
 * @author echo
 * @version V1.0
 * @Package challenge
 * @date 2020/10/4 16:14
 * @leetCode
 */
public class RemoveCoveredIntervals {
    public static int removeCoveredIntervals(int[][] intervals) {
        ArrayList<int[]> lists = new ArrayList<>();
        Collections.addAll(lists, intervals);
        lists.sort((o1, o2) -> o2[0] - o1[0]);

        int res = lists.size();
        int[] max = lists.get(0);
        for (int i = 1; i<lists.size(); ++i){
            int[] curr = lists.get(i);
            if (max[0] >= curr[0] && max[1] >= curr[1]){
                --res;
            }else {
                max = curr;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(removeCoveredIntervals(new int[][]{
                new int[]{1, 3},
                new int[]{3, 6},
                new int[]{2, 8}
        }));

        System.out.println(removeCoveredIntervals(new int[][]{
                new int[]{1, 4},
                new int[]{2, 3}
        }));

        System.out.println(removeCoveredIntervals(new int[][]{
                new int[]{0, 10},
                new int[]{5, 12}
        }));

        System.out.println(removeCoveredIntervals(new int[][]{
                new int[]{3, 10},
                new int[]{4, 10},
                new int[]{5, 11}
        }));

        System.out.println(removeCoveredIntervals(new int[][]{
                new int[]{1, 2},
                new int[]{1, 4},
                new int[]{3, 4}
        }));

        System.out.println(removeCoveredIntervals(new int[][]{
                new int[]{5, 8},
                new int[]{1, 9},
                new int[]{1, 3},
                new int[]{2, 4},
                new int[]{3, 5}
        }));

        System.out.println(removeCoveredIntervals(new int[][]{
                new int[]{34335, 39239},
                new int[]{15875, 91969},
                new int[]{29673, 66453},
                new int[]{53548, 69161},
                new int[]{40618, 93111}
        }));
    }
}
