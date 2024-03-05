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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        
        if(root == null){
            return ans;
        }
        
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        
        boolean right = true;
        
        while(!q.isEmpty()){
            int size = q.size();
            List<Integer> tmp = new ArrayList<>();
            for(int i=0; i<size; i++){
                TreeNode curr = q.poll();
                
                if(curr.left != null){
                    q.add(curr.left);
                }
                if(curr.right != null){
                    q.add(curr.right);
                }
                
                tmp.add(curr.val);
            }
            
            if(right){
                ans.add(tmp);
                right = false;
            }else{
                Collections.reverse(tmp);
                ans.add(tmp);
                right = true;
            }
        }
        
        return ans;
    }
}