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
    
    public int countNodes(TreeNode root) {
        return countNodes(root, -1, -1);
    }
    
    public int countNodes(TreeNode root, int leftHeight, int rightHeight) {
        if (leftHeight == -1) {
            leftHeight = 0;
            TreeNode curr = root;
            while(curr != null) {
                leftHeight++;
                curr = curr.left;
            }
        }
        if (rightHeight == -1) {
            rightHeight = 0;
            TreeNode curr = root;
            while(curr != null) {
                rightHeight++;
                curr = curr.right;
            }
        }
        if (leftHeight == rightHeight)
            return (1 << leftHeight) - 1; // Don't use (int)Math.pow(2, leftHeight) - 1, it's slow.
        else
            return countNodes(root.left, leftHeight - 1, -1) + countNodes(root.right, -1, rightHeight - 1) + 1;
    }
}
