package challenge;

import java.util.*;

/**
 * @author echo
 * @version V1.0
 * @Package challenge
 * @date 2020/9/19 22:52
 * @leetCode 949
 * Given an array arr of 4 digits, find the latest 24-hour time that can be made using each digit exactly once.
 *
 * 24-hour times are formatted as "HH:MM", where HH is between 00 and 23, and MM is between 00 and 59. The earliest
 * 24-hour time is 00:00, and the latest is 23:59.
 *
 * Return the latest 24-hour time in "HH:MM" format.  If no valid time can be made, return an empty string
 */
public class LargestTime {
    public static String largestTimeFromDigits(int[] arr) {
        LinkedList<LinkedList<Integer>> all = new LinkedList<>();
        int[] visited = new int[arr.length];
        getAllTime(all, new LinkedList<Integer>(), arr, visited);
        return selectMax(all);
    }

    private static String selectMax(LinkedList<LinkedList<Integer>> all) {
        if (all.size() == 0){
            return "";
        }
        Optional<Integer> max = all.stream().map((t) -> "" + t.get(0) + t.get(1) + t.get(2) + t.get(3)).map(Integer::parseInt).map((t) -> 10000 + t)
                .max(Integer::compareTo);
        String res = max.get().toString().substring(1);

        return res.substring(0, 2)+":"+res.substring(2);
    }

    /**
     * BUG: 去重剪枝有问题
     */
    private static void getAllTime(LinkedList<LinkedList<Integer>> all, LinkedList<Integer> list, int[] arr, int[] visited) {
        if (list.size() == arr.length){
            LinkedList<Integer> temp = new LinkedList<>(list);
            if (isValidTime(temp))
                all.add(temp);
            return;
        }
        for (int i = 0; i<arr.length; ++i){
            if (visited[i] == 1){
                continue;
            }
            if (i>0 && arr[i] == arr[i-1] && visited[i-1] == 1){
                continue;
            }
            list.add(arr[i]);
            visited[i] = 1;
            getAllTime(all, list, arr, visited);
            list.removeLast();
            visited[i] = 0;
        }
    }

    public static boolean isValidTime(List<Integer> list){
        if (list.get(0) > 2) return false;

        if (list.get(0) == 2){
            return list.get(1) <= 3 && list.get(2)<=5 && list.get(3)<=9;
        }
        return list.get(1)<=9 && list.get(2)<=5 && list.get(3)<=9;
    }

    public static void main(String[] args) {
        System.out.println(largestTimeFromDigits(new int[]{1,2,3,4}));
        System.out.println(largestTimeFromDigits(new int[]{5,5,5,5}));
        System.out.println(largestTimeFromDigits(new int[]{0,0,0,0}));
        System.out.println(largestTimeFromDigits(new int[]{0,0,1,0}));
    }
}
