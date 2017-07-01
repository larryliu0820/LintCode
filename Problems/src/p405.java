import java.util.HashMap;
import java.util.Map;

/**
 * Created by Valued Customer on 6/26/2017.
 * Submatrix Sum
 *
 * Given an integer matrix, find a submatrix where the sum of numbers is zero. Your code should return the coordinate of
 * the left-up and right-down number.
 *
 * Example
 Given matrix

 [
 [1 ,5 ,7],
 [3 ,7 ,-8],
 [4 ,-8 ,9],
 ]
 return [(1,1), (2,2)]
 */
public class p405 {
    /**
     * @param matrix an integer matrix
     * @return the coordinate of the left-up and right-down number
     */
    public int[][] submatrixSum(int[][] matrix) {
        // Write your code
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return null;
        int n = matrix.length;
        int m = matrix[0].length;
        int[][] dp = new int[n+1][m+1];
        int[][] result = new int[2][2];
        for (int i = 0; i <= n; i++) dp[i][0] = 0;
        for (int j = 0; j <= m; j++) dp[0][j] = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                dp[i][j] = dp[i-1][j] + dp[i][j-1] - dp[i-1][j-1] + matrix[i-1][j-1];
            }
        }
        for (int l = 0; l < n; l++) {
            for (int h = l+1; h <= n; h++) {
                Map<Integer, Integer> map = new HashMap<Integer, Integer>();
                for (int j = 0; j <= m; j++) {
                    int diff = dp[h][j] - dp[l][j];
                    if (map.containsKey(diff)) {
                        int k = map.get(diff);
                        result[0][0] = l;
                        result[0][1] = k;
                        result[1][0] = h-1;
                        result[1][1] = j-1;
                        return result;
                    } else {
                        map.put(diff, j);
                    }
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[][] mat = new int[1][];
        mat[0] = new int[]{1,1,1,1,1,1,1,1,1,1,1,-10,1,1,1,1,1,1,1,1,1,1,1};
        p405 sol = new p405();
        System.out.println(sol.submatrixSum(mat));
    }
}
