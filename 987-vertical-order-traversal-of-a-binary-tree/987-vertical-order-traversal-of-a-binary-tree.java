/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    
    class VertNode {
        private int val;
        private int x;
        private int y;
        
        public VertNode(int val, int x, int y)
        {
            this.val = val;
            this.x = x;
            this.y = y;
        }
    }
    
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        //init a list to hold the nodes in correct order
        //call helper to traverse the tree and populate the list
        //now sort the list based on the requirements.
            //if node1.x == node2.x, sort based on y coordinate, which ever is bigger comes first
            //if node1.y == node2.y, sort baded on x coordinate, which ever is smaller comes first
            //otherwise if they are the same sort based on value, node1.val - node2.val
        //init a map
        //loop through every sorted point in the list
        //compute if absent into map
        //loop through map and add all values into output and return
        
        List<VertNode> list = new ArrayList<>();
        populate(root, 0, 0, list);
        Collections.sort(list, (n1, n2) -> n1.x == n2.x ? n1.y == n2.y ? n1.val - n2.val : n2.y - n1.y : n1.x - n2.x);
        
        Map<Integer, List<Integer>> map = new TreeMap<>();
        
        for(VertNode vn : list)
        {
            map.computeIfAbsent(vn.x, a -> new ArrayList<>()).add(vn.val);
        }
        
        List<List<Integer>> output = new ArrayList<>();
        
        for(List<Integer> vertList : map.values())
        {
            output.add(vertList);
        }
        
        return output;
    }
    
    private void populate(TreeNode root, int x, int y, List<VertNode> list)
    {
        if(root == null)
        {
            return;
        }
        
        list.add(new VertNode(root.val, x, y));
        populate(root.left, x - 1, y - 1, list);
        populate(root.right, x + 1, y - 1, list);
    }
}