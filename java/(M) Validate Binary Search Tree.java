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
    public boolean isValidBST(TreeNode root) {
        return helper(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }
    
    private boolean helper(TreeNode node, long min, long max) {
        if (node == null) return true;
        if (min >= node.val || max <= node.val) return false;
        return helper(node.left, min, node.val) && helper(node.right, node.val, max);
    }

/*
    public boolean isValidBST(TreeNode root) {
        if (root == null)
            return true;
        int[] rst = helper(root);
        return (rst[0] == 1);
        if (root == null)
            return true;
    }
    private int[] helper (TreeNode root) {
        int min = root.val;
        int max = root.val;
        if (root.left != null) {
            if (root.left.val >= root.val)
                return new int[]{-1, 0, 0};
            int[] rst = helper(root.left);
            if (rst[0] == -1 || rst[2] >= root.val)
                return new int[]{-1, 0, 0};
            min = rst[1];
        }
        if (root.right != null) {
            if (root.right.val <= root.val)
                return new int[]{-1, 0, 0};
            int[] rst = helper(root.right);
            if (rst[0] == -1 || rst[1] <= root.val)
                return new int[]{-1, 0, 0};
            max = rst[2];
        }
        return new int[]{1, min, max};
    }
*/
}
