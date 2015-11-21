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
    public List<Integer> postorderTraversal(TreeNode root) {
        if (root == null)
            return new ArrayList<Integer>();

        if (root.left == null && root.right == null) {
            List<Integer> list = new ArrayList<Integer>();
            list.add(root.val);
            return list;
        }

        List<Integer> list = new ArrayList<Integer>();
        if (root.left != null) {
            list = postorderTraversal(root.left);
        }
        if (root.right != null) {
            list.addAll(postorderTraversal(root.right));
        }
        list.add(root.val);
        return list;
    }
}
