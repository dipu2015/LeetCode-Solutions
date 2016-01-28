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
    
    public TreeNode upsideDownBinaryTree(TreeNode root) {
        if (root == null)
            return root;
        TreeNode newRoot = helper(root, null, null);
        return newRoot;
    }
    
    private TreeNode helper(TreeNode node, TreeNode parent, TreeNode rightSibling) {
        TreeNode leftChild = node.left;
        TreeNode rightChild = node.right;

        node.left = rightSibling;
        node.right = parent;

        if (leftChild == null)
            return node;
        return helper(leftChild, node, rightChild);
    }
}
