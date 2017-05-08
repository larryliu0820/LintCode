/**
 * Created by Valued Customer on 4/23/2017.
 *
 * Find Peak Element
 *
 * There is an integer array which has the following features:

 The numbers in adjacent positions are different.
 A[0] < A[1] && A[A.length - 2] > A[A.length - 1].
 We define a position P is a peek if:

 A[P] > A[P-1] && A[P] > A[P+1]
 Find a peak element in this array. Return the index of the peak.

 Example
 Given [1, 2, 1, 3, 4, 5, 7, 6]

 Return index 1 (which is number 2) or 6 (which is number 7)

 */
public class p075 {
    /**
     * @param A: An integers array.
     * @return: return any of peek positions.
     */
    public int findPeak(int[] A) {
        // write your code here
        if (A == null || A.length == 0) return -1;
        if (A.length == 3) return 1;
        int left = 0, right = A.length - 1;
        int mid = -1;
        while (left <= right) {
            mid = (left + right)/2;
            if ((mid != 0 && A[mid-1] <= A[mid]) && (mid != A.length - 1 && A[mid+1] <= A[mid]))
                return mid;
            if (mid != 0 && A[mid] < A[mid - 1]) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return mid;
    }

    public static void main(String[] args) {
        p075 sol = new p075();
        sol.findPeak(new int[]{1,2,1,2,3,1});
    }
}
