import java.util.ArrayList;
import java.util.List;

/**
 * Created by Valued Customer on 4/26/2017.
 *
 * Find Peak Element II

 There is an integer matrix which has the following features:

 The numbers in adjacent positions are different.
 The matrix has n rows and m columns.
 For all i < m, A[0][i] < A[1][i] && A[n - 2][i] > A[n - 1][i].
 For all j < n, A[j][0] < A[j][1] && A[j][m - 2] > A[j][m - 1].
 We define a position P is a peek if:

 A[j][i] > A[j+1][i] && A[j][i] > A[j-1][i] && A[j][i] > A[j][i+1] && A[j][i] > A[j][i-1]
 Find a peak element in this matrix. Return the index of the peak.

 Example
 Given a matrix:

 [
 [1 ,2 ,3 ,6 ,5],
 [16,41,23,22,6],
 [15,17,24,21,7],
 [14,18,19,20,10],
 [13,14,11,10,9]
 ]
 return index of 41 (which is [1,1]) or index of 24 (which is [2,2])
 */
public class p390 {
    public List<Integer> findPeakII(int[][] A) {
        // write your code here
        // write your code here
        List<Integer> result = new ArrayList<>();
        if (A == null || A.length == 0 || A[0].length == 0) return result;
        int high = 0, low = A.length - 1;
        int left = 0, right = A[0].length - 1;
        int midX = -1, midY = -1;
        while (left <= right) {
            midX = (left + right)/2;
            midY = (high + low)/2;
            int midVal = A[midY][midX];
            if ((midVal > A[midY+1][midX]) &&
                    (midVal > A[midY-1][midX]) &&
                    (midVal > A[midY][midX+1]) &&
                    (midVal > A[midY][midX-1])) {
                result.add(midY);
                result.add(midX);
                return result;
            }
            if (midVal <= A[midY-1][midX]) {
                low = midY;
            } else if (midVal <= A[midY+1][midX]) {
                high = midY;
            } else {
                if (midVal <= A[midY][midX - 1]) {
                    right = midX;
                } else if (midVal <= A[midY][midX + 1]) {
                    left = midX;
                }
            }
        }
        return null;
    }

    public static void main(String[] args) {
        int[][] input = new int[][]{
                {161,163,21,  58,  12,  931, 18,  75,  65,  122,535, 172},
                {376,639,152, 284, 298, 1559,89,  214, 127, 123,683, 216},
                {78, 165,1046,704, 1163,785, 1426,1388,139, 109,1562,506},
                {73, 508,1222,87,  297, 16,  405, 102, 33,  115,156, 113},
                {196,826,1952,1928,45,  59,  197, 71,  1035,31, 179, 103},
                {151,169,11,  355, 1641,74,  38,  108, 88,  946,1982,825},
                {25, 417,1192,1214,1772,117, 973, 1302,616, 185,180, 48},
                {173,883,188, 245, 1446,668, 153, 685, 1716,762,486, 361},
                {55, 105,93,  112, 1145,193, 118, 289, 167, 159,168, 41}
        };
        p390 sol = new p390();
        List<Integer> result = sol.findPeakII(input);
        for (int i : result) {
            System.out.println(i);
        }
    }
}
