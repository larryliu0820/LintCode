import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * Created by Valued Customer on 3/3/2017.
 * Two Sum
 *
 * Given an array of integers, find two numbers such that they add up to a specific target number.

 The function twoSum should return indices of the two numbers such that they add up to the target, where index1 must be
 less than index2. Please note that your returned answers (both index1 and index2) are NOT zero-based.
 Notice

 You may assume that each input would have exactly one solution

 Example
 numbers=[2, 7, 11, 15], target=9

 return [1, 2]
 */
public class p056 {
    public int median3(int[] numbers, int low, int high) {
        int head = numbers[low],tail = numbers[high];
        int mid = numbers[(low + high) / 2];
        if (head >= tail) {
            if (tail >= mid) return high;
            else if (head >= mid) return (low+high)/2;
            else return low;
        } else {
            if (head >= mid) return low;
            else if (tail >= mid) return (low+high)/2;
            else return high;
        }
    }

    public void qsort(int[] numbers, int[] indices, int high, int low) {
        int pivotIndex = median3(numbers, low, high);
        int pivot = numbers[pivotIndex];
        swap(numbers, pivotIndex, (high + low) /2);
        swap(indices, pivotIndex, (high + low) /2);

        int l = low, h = high;
        while (l <= h) {
            while (numbers[l] < pivot) l++;
            while (numbers[h] > pivot) h--;
            if (l <= h) {
                swap(numbers, l, h);
                swap(indices, l, h);
                l++;
                h--;
            }
        }
        if (low < h) qsort(numbers, indices, h, low);
        if (l < high) qsort(numbers, indices, high, l);
    }

    public void swap(int[] numbers, int i, int j) {
        int temp = numbers[i];
        numbers[i] = numbers[j];
        numbers[j] = temp;
    }
    /*
    * @param numbers : An array of Integer
    * @param target : target = numbers[index1] + numbers[index2]
    * @return : [index1 + 1, index2 + 1] (index1 < index2)
    */
    public int[] twoSum(int[] numbers, int target) {
        // write your code here
        int[] indices = new int[numbers.length];
        for (int i = 0; i < numbers.length; i++) indices[i] = i;
        qsort(numbers, indices, numbers.length-1, 0);
        int left = 0, right = numbers.length - 1;
        int[] result = new int[2];
        while (left < right) {
            int sum = numbers[left] + numbers[right];
            if (sum == target) {
                int smallerInd = indices[left] > indices[right]?indices[right]:indices[left];
                int largerInd = indices[left] > indices[right]?indices[left]:indices[right];;
                result[0] = smallerInd+1;
                result[1] = largerInd+1;
                break;
            } else if(sum < target) {
                left++;
            } else {
                right--;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        p056 sol = new p056();
        int[] nums = new int[]{11, 7, 2, 15};
        int[] indices = new int[nums.length];
        for (int i = 0; i < nums.length; i++) indices[i] = i;
        sol.qsort(nums, indices, 3, 0);
        System.out.println(Arrays.toString(nums));
        System.out.println(Arrays.toString(indices));
    }

}
