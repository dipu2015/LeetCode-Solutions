/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) 
            return "";
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        StringBuilder res = new StringBuilder();
        q.add(root);
        while(!q.isEmpty()) {
            TreeNode node = q.poll();
            if (node == null) {
                res.append("n ");
            }
            else {
                res.append(node.val + " ");
                q.add(node.left);
                q.add(node.right);
            }
        }
        return res.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.length() == 0)
            return null;
            
        String[] values = data.split(" ");
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        TreeNode root = new TreeNode(Integer.parseInt(values[0]));
        q.add(root);
        
        for (int i=1; i<values.length; i++) {
            TreeNode node = q.poll();
            if (!values[i].equals("n")) {
                TreeNode left = new TreeNode(Integer.parseInt(values[i]));
                node.left = left;
                q.add(left);
            }
            if (!values[++i].equals("n")) {
                TreeNode right = new TreeNode(Integer.parseInt(values[i]));
                node.right = right;
                q.add(right);
            }
        }
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));
