/**
 * Created by Valued Customer on 4/18/2017.
 *
 * Implement int sqrt(int x).

 Compute and return the square root of x.

 Example
 sqrt(3) = 1

 sqrt(4) = 2

 sqrt(5) = 2

 sqrt(10) = 3

 Challenge
 O(log(x))
 */
public class p141 {
    /**
     * @param x: An integer
     * @return: The sqrt of x
     */
    public int sqrt(int x) {
        // write your code here
        if (x == 0 || x == 1) return x;
        int left = 1, right = x, mid = x / 2;
        while (left < right - 1) {
            if (left == x / left) return left;
            if (right == x / right) return right;
            mid = (left + right) / 2;
            if (mid > x / mid) {
                right = mid;
            } else if (mid == x / mid) return mid;
            else {
                left = mid;
            }
        }
        return (left + right) / 2;
    }

    public static void main(String[] args) {
        p141 sol = new p141();
        System.out.println(sol.sqrt(10));
    }
}
