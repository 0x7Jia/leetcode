package challenge;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author echo
 * @version V1.0
 * @Package challenge
 * @date 2020/10/4 14:22
 * @leetCode 39
 */
public class CombinationSum {
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if (candidates == null || candidates.length == 0){
            return res;
        }
        dfs(candidates, candidates.length, target, 0, new ArrayList<Integer>(), res);
        return res;
    }

    private static void dfs(int[] candidates, int arrLen, int target, int selectIdx, ArrayList<Integer> curPath, List<List<Integer>> res) {
        if (selectIdx >= arrLen || target < 0){
            return;
        }
        if (target == 0){
            res.add(new ArrayList<>(curPath));
            return;
        }

        for (int i = selectIdx; i<arrLen; ++i){
            curPath.add(candidates[i]);
            dfs(candidates, arrLen, target-candidates[i], i, curPath, res);
            if (curPath.size() > 0 )
                curPath.remove(curPath.size()-1);
        }
    }

    public static void main(String[] args) {
        System.out.println(combinationSum(new int[]{2,3,6,7}, 7));
        System.out.println(combinationSum(new int[]{2,3,5}, 8));
        System.out.println(combinationSum(new int[]{2}, 1));
        System.out.println(combinationSum(new int[]{1}, 1));
        System.out.println(combinationSum(new int[]{1}, 2));
        System.out.println(combinationSum(new int[]{1, 2}, 4));
        System.out.println(combinationSum(new int[]{2,7,6,3,5,1}, 9).size());

    }
}
