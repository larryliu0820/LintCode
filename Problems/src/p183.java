/**
 * Created by Valued Customer on 5/6/2017.
 *
 * Given n pieces of wood with length L[i] (integer array). Cut them into small pieces to guarantee you could have equal
 * or more than k pieces with the same length. What is the longest length you can get from the n pieces of wood?
 * Given L & k, return the maximum length of the small pieces.
 * You couldn't cut wood into float length.

     If you couldn't get >= k pieces, return 0.
 * Example
 For L=[232, 124, 456], k=7, return 114.
 */
public class p183 {
    /**
     *@param L: Given n pieces of wood with length L[i]
     *@param k: An integer
     *return: The maximum length of the small pieces.
     */
    public int woodCut(int[] L, int k) {
        // write your code here
        int max = Integer.MIN_VALUE;
        for (int i : L) {
            if (i > max) max = i;
        }
        int low = 1, high = max;
        int mid;
        while (low + 1 < high) {
            mid = low / 2 + high / 2 + ((low % 2) + (high % 2)) / 2;
            if (isValid(L, mid, k)) {
                low = mid;
            } else {
                high = mid;
            }
        }
        if (!isValid(L, low, k)) {
            return 0;
        }
        return low;
    }

    private boolean isValid(int[] L, int len, int k) {
        int count = 0;
        for (int i : L) {
            count += i / len;
        }
        return count >= k;
    }

    public static void main(String[] args) {
        p183 sol = new p183();
        int[] L = new int[] {232, 124, 456};
        System.out.println(sol.woodCut(L, 7));
    }
}
