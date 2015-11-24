/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {

    int max = 0;
    int depth = 0;

    public int maxDepth(TreeNode root) {
        if (root == null) return 0;

        depth++;
        if (root.left == null && root.right == null) {
            if (depth > max)
                max = depth;
        }
        else {
            if (root.left != null)
                maxDepth(root.left);
            if (root.right != null)
                maxDepth(root.right);
        }
        depth--;

        return max;
    }
}
