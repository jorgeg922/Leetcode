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
    public TreeNode reverseOddLevels(TreeNode root) {
        if(root.right == null && root.left == null){
            return root;
        }
        
        
        Queue<TreeNode> nodes = new LinkedList<>();
        nodes.add(root);
        boolean doReverse = false;
        
        while(!nodes.isEmpty()){
            int size = nodes.size();
            List<TreeNode> levelNodes = new ArrayList<>();
            for(int i=0; i<size; i++){
                TreeNode curr = nodes.poll();
                levelNodes.add(curr);
                if(curr.left != null){
                    nodes.add(curr.left);
                }
                if(curr.right != null){
                    nodes.add(curr.right);
                }              
            }
            
            if(doReverse){
                int left = 0;
                int right = levelNodes.size()-1;
            
                while(left < right){
                    int tmp = levelNodes.get(left).val;
                    levelNodes.get(left).val = levelNodes.get(right).val;
                    levelNodes.get(right).val = tmp;
                    left++;
                    right--;
                }
            }
                            
            doReverse = !doReverse;
           
        }
        
        return root;
    }
    
    
}