import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * Created by Valued Customer on 5/7/2017.
 * Maximal Square
 *
 * Given a 2D binary matrix filled with 0's and 1's, find the largest square
 * containing all 1's and return its area.
 *
 * Example
 For example, given the following matrix:

 1 0 1 0 0
 1 0 1 1 1
 1 1 1 1 1
 1 0 0 1 0
 Return 4.
 */
public class p436 {
    /**
     * @param matrix: a matrix of 0 and 1
     * @return: an integer
     */
    public int maxSquare(int[][] matrix) {
        // write your code here
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return 0;
        int[][] dp = new int[matrix.length+1][matrix[0].length+1];

        int max = 0;
        for (int row = 1; row < dp.length; row++) {
            for (int col = 1; col < dp[0].length; col++) {
                if (matrix[row-1][col-1] == 1) {
                    dp[row][col] = Math.min(Math.min(dp[row-1][col], dp[row][col-1]), dp[row-1][col-1]) + 1;
                    max = Math.max(max, dp[row][col]);
                }
            }
        }
        return max*max;
    }

    public static void main(String[] args) {
        p436 sol = new p436();
        String filename = "Problems/src/6.in";
        int[][] data = null;
        try {
            FileReader fileReader = new FileReader(filename);

            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String content = bufferedReader.readLine();
            String[] list = content.split("]");

            data = new int[list.length][];
            for (int i = 0; i < list.length; i++) {
                String nums = list[i].substring(2);
                String[] numList = nums.split(",");
                data[i] = new int[numList.length];
                for (int j = 0; j < numList.length; j++) data[i][j] = Integer.parseInt(numList[j]);
            }
        } catch (FileNotFoundException ex) {
            System.out.println("no such file");
        } catch (IOException ex) {
            System.out.println("Error");
        }

        System.out.println(sol.maxSquare(data));

    }
}
