/**
 * Created by Valued Customer on 6/23/2017.
 * Flatten Binary Tree to Linked List
 *
 * Flatten a binary tree to a fake "linked list" in pre-order traversal.

 Here we use the right pointer in TreeNode as the next pointer in ListNode.

 Notice

 Don't forget to mark the left child of each node to null. Or you will get Time Limit Exceeded or Memory Limit Exceeded.

 Example
              1
               \
     1          2
    / \          \
   2   5    =>    3
  / \   \          \
 3   4   6          4
                     \
                      5
                       \
                        6
 */
public class p453 {
    /**
     * @param root: a TreeNode, the root of the binary tree
     * @return: nothing
     */
    public void flatten(TreeNode root) {
        // write your code here
        helper(root);
    }

    private TreeNode helper(TreeNode root) {
        if (root == null) return null;
        TreeNode node = root;
        TreeNode left = root.left;
        TreeNode right = root.right;
        if (left != null) {
            node.right = left;
            node.left = null;
            node = helper(left);
        }
        if (right != null) {
            node.right = right;
            node.left = null;
            node = helper(right);
        }
        return node;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        p453 sol = new p453();
        sol.flatten(root);
        System.out.print(root.val);
    }
}
