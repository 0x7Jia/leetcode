package challenge;

/**
 * @author echo
 * @version V1.0
 * @Package challenge
 * @date 2020/9/27 14:49
 * @leetCode 495
 * Input: [1,4], 2
 * Output: 4
 * Explanation: At time point 1, Teemo starts attacking Ashe and makes Ashe be poisoned immediately.
 * This poisoned status will last 2 seconds until the end of time point 2.
 * And at time point 4, Teemo attacks Ashe again, and causes Ashe to be in poisoned status for another 2 seconds.
 * So you finally need to output 4.
 */
public class TeemoAttacking {
    public static int findPoisonedDuration(int[] timeSeries, int duration) {
        int len = timeSeries.length;
        if (len == 0){
            return 0;
        }
        int durationTime = 0;
        for (int i = 0; i<len-1; ++i){
            int currEndTime = timeSeries[i] + duration;
            int nextAttackStartTime = timeSeries[i+1];
            if (currEndTime <= nextAttackStartTime){
                durationTime += duration;
            }else {
                int t = nextAttackStartTime - timeSeries[i];
                durationTime += t;
            }
        }

        return durationTime+duration;
    }

    public static void main(String[] args) {
        System.out.println(findPoisonedDuration(new int[]{1, 4}, 7));
    }
}
