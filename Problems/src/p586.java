/**
 * Created by Valued Customer on 4/22/2017.
 *
 * Implement double sqrt(double x) and x >= 0.

 Compute and return the square root of x.

 Notice

 You do not care about the accuracy of the result, we will help you to output results.
 *
 */
public class p586 {
    /**
     * @param x a double
     * @return the square root of x
     */
    public double sqrt(double x) {
        // Write your code here
        if (x == 0 || x == 1.0) return x;
        double left, right, mid;

        if (x > 1.0) {
            left = 0;
            right = x;
        } else {
            left = x;
            right = 1;
        }
        while (right - left > 1e-10) {
            mid = (left + right) / 2;
            System.out.println("mid = " + mid);
            if (x / mid > mid) {
                left = mid;
            } else if (x / mid < mid) {
                right = mid;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        p586 sol = new p586();
        System.out.println(sol.sqrt(2));
    }
}
