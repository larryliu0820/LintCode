import java.util.Arrays;

/**
 * Created by larryliu on 12/4/16.
 * 给定一个整数数组，在该数组中，寻找三个数，分别代表三角形三条边的长度，问，可以寻找到多少组这样的三个数来组成三角形？
 * 样例
 例如，给定数组 S = {3,4,6,7}，返回 3

 其中我们可以找到的三个三角形为：

 {3,4,6}
 {3,6,7}
 {4,6,7}
 给定数组 S = {4,4,4,4}, 返回 4

 其中我们可以找到的三个三角形为：

 {4(1),4(2),4(3)}
 {4(1),4(2),4(4)}
 {4(1),4(3),4(4)}
 {4(2),4(3),4(4)}
 */
public class p382 {
    /**
     * @param S: A list of integers
     * @return: An integer
     */
    public int triangleCount(int S[]) {
        // write your code here
        int left = 0, right = S.length - 1;
        int ans = 0;
        Arrays.sort(S);
        for(int i = 0; i < S.length; i++) {
            left = 0;
            right = i - 1;
            while(left < right) {
                if(S[left] + S[right] > S[i]) {
                    ans = ans + (right - left);
                    right --;
                } else {
                    left ++;
                }
            }
        }
        return ans;
    }
}
