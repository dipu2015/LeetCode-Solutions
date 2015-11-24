/*
Two elements of a binary search tree (BST) are swapped by mistake.

Recover the tree without changing its structure.

Note:
A solution using O(n) space is pretty straight forward. Could you devise a constant space solution?
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

    TreeNode n1 = null, n2 = null, pre = null;

    public void recoverTree(TreeNode root) {
        if (root == null)
            return;
        inOrder(root);
        int temp = n1.val;
        n1.val = n2.val;
        n2.val = temp;
    }
    
    private void inOrder(TreeNode node) {
        if (node.left != null) 
            inOrder(node.left);
        if (pre != null && pre.val > node.val) {
            if (n1 == null)
                n1 = pre;
            n2 = node;
        }
        pre = node;
        if (node.right != null)
            inOrder(node.right);
    }
}
