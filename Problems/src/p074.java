/**
 * Created by Valued Customer on 4/24/2017.
 *
 * First Bad Version
 *
 * The code base version is an integer start from 1 to n. One day, someone committed a bad version in the code case, so it caused this version and the following versions are all failed in the unit tests. Find the first bad version.

 You can call isBadVersion to help you determine which version is the first bad one. The details interface can be found in the code's annotation part.

 Notice

 Please read the annotation in code area to get the correct way to call isBadVersion in different language. For example, Java is SVNRepo.isBadVersion(v)

 Example
 Given n = 5:

 isBadVersion(3) -> false
 isBadVersion(5) -> true
 isBadVersion(4) -> true
 Here we are 100% sure that the 4th version is the first bad version.
 */
public class p074 {
    /**
     * @param n: An integers.
     * @return: An integer which is the first bad version.
     */
    public int findFirstBadVersion(int n) {
        // write your code here
        if (n == 1) return 1;
        int left = 1, right = n;
        int mid = 0;
        while (left <= right) {
            mid = left / 2 + right / 2;
            if (SVNRepo.isBadVersion(mid)) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return SVNRepo.isBadVersion(mid)?mid:mid+1;
    }

    public static void main(String[] args) {
        p074 sol = new p074();
        System.out.println(sol.findFirstBadVersion(2147483647));
    }
}
