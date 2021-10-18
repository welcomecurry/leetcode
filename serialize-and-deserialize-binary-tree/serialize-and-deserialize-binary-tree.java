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
        if(root == null) return "null";
        
        StringBuilder sb = new StringBuilder();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        
        while(!queue.isEmpty())
        {
            int size = queue.size();
            
            while(size-- > 0)
            {
                TreeNode currNode = queue.poll();
                
                if(currNode == null)
                {
                    sb.append("null ");
                }
                else
                {
                    queue.add(currNode.left);
                    queue.add(currNode.right);
                    sb.append(currNode.val).append(" ");
                }
            }
        }
        
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        
        if(data.equals("") || data.equals("null")) return null;
        
        String[] nodes = data.split(" ");
        TreeNode root = new TreeNode(Integer.valueOf(nodes[0]));
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        
        int index = 1;
        
        while(!queue.isEmpty())
        {
            int size = queue.size();
            
            while(size-- > 0)
            {
                TreeNode currNode = queue.poll();
                
                if(!nodes[index].equals("null"))
                {
                    TreeNode left = new TreeNode(Integer.valueOf(nodes[index]));
                    currNode.left = left;
                    queue.add(currNode.left);
                }
                
                index++;
                    
                if(!nodes[index].equals("null"))
                {
                    TreeNode right = new TreeNode(Integer.valueOf(nodes[index]));
                    currNode.right = right;
                    queue.add(currNode.right);
                }
                
                index++;
            }
        }
        
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));