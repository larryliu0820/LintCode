/**
 * Created by Valued Customer on 5/23/2017.
 *
 * Given n items with size Ai, an integer m denotes the size of a backpack. How full you can fill this backpack?
 *
 *  Notice

 You can not divide any item into small pieces.
 Example
 If we have 4 items with size [2, 3, 5, 7], the backpack size is 11, we can select [2, 3, 5], so that the max size we
 can fill this backpack is 10. If the backpack size is 12. we can select [2, 3, 7] so that we can fulfill the backpack.

 You function should return the max size we can fill in the given backpack.

 Challenge
 O(n x m) time and O(m) memory.

 O(n x m) memory is also acceptable if you do not know how to optimize memory.
 */
public class p092 {
    /**
     * @param m: An integer m denotes the size of a backpack
     * @param A: Given n items with size A[i]
     * @return: The maximum size
     */
    public int backPack(int m, int[] A) {
        // write your code here
        if (A == null || A.length == 0) return 0;
        int[][] dp = new int[2][m+1];
        for (int j = 1; j <= A.length; j++) {
            for (int i = 1; i <= m; i++) {

                if (A[j-1] > i) dp[j%2][i] = dp[(j-1)%2][i];
                else dp[j%2][i] = Math.max(dp[(j-1)%2][i], A[j-1] + dp[(j-1)%2][i-A[j-1]]);
            }
        }
        return dp[A.length%2][m];
    }

    public static void main(String[] args) {
        int[] A = new int[]{12,3,7,4,5,13,2,8,4,7,6,5,7};
        p092 sol = new p092();
        System.out.println(sol.backPack(90, A));
    }
}
