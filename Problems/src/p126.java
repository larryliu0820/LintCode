import java.util.Stack;

/**
 * Created by Valued Customer on 4/9/2017.
 * Max Tree
 *
 * Given an integer array with no duplicates. A max tree building on this array is defined as follow:

 The root is the maximum number in the array
 The left subtree and right subtree are the max trees of the subarray divided by the root number.
 Construct the max tree by the given array.

 Example
 Given [2, 5, 6, 0, 3, 1], the max tree constructed by this array is:

     6
    / \
   5   3
  /   / \
 2   0   1
 */
public class p126 {
    /**
     * @param A: Given an integer array with no duplicates.
     * @return: The root of max tree.
     */
    public TreeNode maxTree(int[] A) {
        // write your code here
        if (A == null || A.length == 0) return null;
        return maxTreeUtil(A, 0, A.length - 1);
    }

    private TreeNode maxTreeUtil(int[] A, int begin, int end) {
        if (begin > end) return null;
        int currMaxInd = getMax(A, begin, end);
        TreeNode root = new TreeNode(A[currMaxInd]);
        root.left = maxTreeUtil(A, begin, currMaxInd - 1);
        root.right = maxTreeUtil(A, currMaxInd + 1, end);
        return root;
    }

    private int getMax(int[] A, int begin, int end) {
        if (begin == end) return begin;
        int maxInd = begin;
        for (int i = begin; i <= end; i++) {
            if (A[maxInd] < A[i]) {
                maxInd = i;
            }
        }
        return maxInd;
    }

    public TreeNode maxTree2(int[] A) {
        if (A == null || A.length == 0) return null;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode root = null;
        for (int i = 0; i < A.length; i++) {
            TreeNode currNode = new TreeNode(A[i]);
            if (stack.isEmpty()) {
                stack.push(currNode);
                root = currNode;
            } else {
                if (stack.peek().val < A[i]) {
                    TreeNode target = null;
                    while (!stack.isEmpty() && stack.peek().val < A[i]) target = stack.pop();
                    if (stack.isEmpty()) {
                        stack.push(currNode);
                        root = currNode;
                        currNode.left = target;
                    } else {
                        stack.peek().right = currNode;
                        currNode.left = target;
                        stack.push(currNode);
                    }
                } else {
                    stack.peek().right = currNode;
                    stack.push(currNode);
                }
            }
        }
        return root;
    }

    public static void main(String[] args) {
        p126 sol = new p126();
        sol.maxTree2(new int[]{2, 5, 1, 4, 6, 0, 3});
    }
}
