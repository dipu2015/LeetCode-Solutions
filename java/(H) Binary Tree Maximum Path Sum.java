/*
Given a binary tree, find the maximum path sum.

For this problem, a path is defined as any sequence of nodes from some starting node to any node in the tree along the parent-child connections. The path does not need to go through the root.

For example:
Given the below binary tree,

       1
      / \
     2   3
Return 6.
*/

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
    
    int maxValue = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        if (root == null)
            return 0;
            
        helper(root);
        return maxValue;
    }
    
    int helper(TreeNode node) {
        int p1 = Integer.MIN_VALUE;
        int p2 = Integer.MIN_VALUE;
        
        if (node.left != null) {
            p1 = helper(node.left);
        }
        if (node.right != null) {
            p2 = helper(node.right);
        }
        
        int me = node.val;
        int meAndLeft = node.val;
        int meAndRight = node.val;
        if (p1 != Integer.MIN_VALUE)
            meAndLeft = p1 + node.val;
        if (p2 != Integer.MIN_VALUE)
            meAndRight = p2 + node.val;
            
        int bridgePath = node.val;
        if (p1 != Integer.MIN_VALUE)
            bridgePath += p1;
        if (p2 != Integer.MIN_VALUE)
            bridgePath += p2;
        
        int localMax = Math.max(Math.max(Math.max(meAndLeft, meAndRight), bridgePath), node.val);
        if (localMax > maxValue)
            maxValue = localMax;

        return Math.max(Math.max(meAndLeft, meAndRight), me);
    }
}
