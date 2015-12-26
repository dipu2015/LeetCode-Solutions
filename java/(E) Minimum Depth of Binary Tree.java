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
    public int minDepth(TreeNode root) {
        if (root == null)
            return 0;
            
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        int last = 1;
        int curr = 0;
        int level = 1;
        while(!queue.isEmpty()) {
            TreeNode node = queue.poll();
            last--;
            
            if (node.left == null && node.right == null)
                return level;
            
            if (node.left != null) {
                queue.add(node.left);
                curr++;
            }
            if (node.right != null) {
                queue.add(node.right);
                curr++;
            }
            
            if (last == 0) {
                last = curr;
                curr = 0;
                level++;
            }
        }
        
        return level;
    }
}
