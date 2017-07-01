import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by Valued Customer on 6/29/2017.
 * Subarray Sum Closest
 *
 * Given an integer array, find a subarray with sum closest to zero. Return the indexes of the first number and last
 * number.
 *
 * Example
 Given [-3, 1, 1, -3, 5], return [0, 2], [1, 3], [1, 1], [2, 2] or [0, 4].
 */
public class p139 {


    private class Pair {
        int value;
        int index;
        public Pair(int i, int v) {
            value = v;
            index = i;
        }
        public Pair() {}
    }
    /**
     * @param nums: A list of integers
     * @return: A list of integers includes the index of the first number
     *          and the index of the last number
     */
    public int[] subarraySumClosest(int[] nums) {
        // write your code here
        int[] result = new int[2];
        if (nums == null) return result;
        int len = nums.length;
        if (len < 2) return result;

        Pair[] sum = new Pair[len];
        sum[0] = new Pair(0, nums[0]);
        for (int i = 1; i < len; i++) {
            sum[i] = new Pair(i, sum[i-1].value + nums[i]);
        }

        Arrays.sort(sum, new Comparator<Pair>() {
            @Override
            public int compare(Pair pair, Pair t1) {
                return pair.value - t1.value;
            }
        });

        int diff = Integer.MAX_VALUE;
        for (int i = 1; i < len; i++) {
            int currDiff = Math.abs(sum[i].value - sum[i-1].value);
            if ( currDiff < diff) {
                diff = currDiff;
                result[0] = sum[i].index;
                result[1] = sum[i-1].index;
                Arrays.sort(result);
                result[0]++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{6,-4,-8,3,1,7};
        p139 sol = new p139();
        sol.subarraySumClosest(nums);
    }
}
