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
    
    TreeNode rst = null;
    
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        dfs(root, p ,q);
        return rst;
    }
    
    private int dfs(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null)
            return 0;
            
        int found = 0;
        if (root == p || root == q)
            found = 1;

        found += dfs(root.left, p ,q);
        if (found == 2) {
            if (rst == null)
                rst = root;
            return 2;
        }

        found += dfs(root.right, p ,q);
        if (found == 2) {
            if (rst == null)
               rst = root;
            return 2;
        }
        
        return found;
    }
}
