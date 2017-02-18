import java.util.*;

/**
 * Created by Valued Customer on 12/21/2016.
 * Given n x m non-negative integers representing an elevation map 2d where the area of each cell is 1 x 1,
 * compute how much water it is able to trap after raining.
 * Example
 Given 5*4 matrix

 [12,13,0,12]
 [13,4,13,12]
 [13,8,10,12]
 [12,13,12,12]
 [13,13,13,13]
 return 14.
 */
public class p364 {

    public class Point {
        int row;
        int col;
        int val;
        public Point(int r, int c, int v) {
            row = r;
            col = c;
            val = v;
        }
    }
    public class PointComparator implements Comparator<Point> {
        @Override
        public int compare(Point p1, Point p2) {
            return p2.val - p1.val;
        }
    }
    private int result = 0;
    /**
     * @param heights: a matrix of integers
     * @return: an integer
     */
    public int trapRainWater(int[][] heights) {
        // write your code here
        if (heights == null || heights.length == 0 || heights[0] == null || heights[0].length == 0) return 0;
        PriorityQueue<Point> pq = new PriorityQueue<>((n, m)->n.val-m.val);
        boolean[][] visited = new boolean[heights.length][heights[0].length];
        for (int row = 0; row < heights.length; row++) {
            if (row == 0 || row == heights.length-1) {
                for (int col = 0; col < heights[0].length; col++) {
                    pq.offer(new Point(row, col, heights[row][col]));
                    visited[row][col] = true;
                }
            }else {
                pq.offer(new Point(row, 0, heights[row][0]));
                pq.offer(new Point(row, heights[0].length-1, heights[row][heights[0].length-1]));
                visited[row][0] = true;
                visited[row][heights[0].length-1] = true;
            }
        }

        bfs(heights, visited, pq);
        return result;
    }


    private void bfs(int[][] heights, boolean[][] visited, PriorityQueue<Point> pq) {
        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, 1, 0, -1};
        while (!pq.isEmpty()) {
            Point curr = pq.poll();
            for (int i = 0; i < 4; i++) {
                int nextRow = curr.row + dx[i];
                int nextCol = curr.col + dy[i];
                if (nextRow >= 0 && nextRow < heights.length
                        && nextCol >= 0 && nextCol < heights[0].length
                        && ! visited[nextRow][nextCol]) {
                    visited[nextRow][nextCol] = true;
                    pq.offer(new Point(nextRow, nextCol, Math.max(curr.val, heights[nextRow][nextCol])));
                    result += Math.max(0, curr.val - heights[nextRow][nextCol]);
                }
            }
        }
    }

    public static void main(String[] args) {
        p364 sol = new p364();
        int[][] heights = new int[][]{
                {19,13,63,93,76},
                {68,8,37,70,97},
                {80,38,98,10,52},
                {23,61,5,20,54},
                {79,88,51,40,26},
                {10,77,24,34,29},
                {87,59,50,3,37},
                {25,0,87,77,70},
                {72,47,98,41,48}
        };
        System.out.println(sol.trapRainWater(heights));
    }
}
