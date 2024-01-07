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
    public List<Integer> rightSideView(TreeNode root) {
        if(root == null){
            return new ArrayList<Integer>();
        }
        
        List<Integer> ans = new ArrayList<>();
        
        Deque<TreeNode> q = new LinkedList<>();
        q.addLast(root);
        while(!q.isEmpty()){
            ans.add(q.peekLast().val);
            int size = q.size();
            for(int i=0; i<size; i++){
                TreeNode curr = q.pollFirst();
                if(curr.left != null){
                    q.addLast(curr.left);
                }
                if(curr.right != null){
                    q.addLast(curr.right);
                }
            }
        }
        
        return ans;
    }
    
   
}