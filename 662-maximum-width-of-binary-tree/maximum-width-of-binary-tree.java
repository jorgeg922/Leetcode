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
    public int widthOfBinaryTree(TreeNode root) {
        int maxWidth = 0;
        
        Queue<Pair<TreeNode,Integer>> queue = new LinkedList<>();
        queue.add(new Pair(root,0));
        
 
        while(!queue.isEmpty()){
            Pair<TreeNode,Integer> firstInLevel = queue.peek();
            int size = queue.size();
            for(int i=0; i<size; i++){
                Pair<TreeNode, Integer> curr = queue.poll();
                TreeNode node = curr.getKey();
                if(node.left != null){
                    queue.add(new Pair(node.left,2*curr.getValue()));
                }
                if(node.right != null){
                    queue.add(new Pair(node.right,2*curr.getValue() + 1));
                }
                
                maxWidth = Math.max(maxWidth, curr.getValue() - firstInLevel.getValue() + 1);
            }
            
        }
        
        return maxWidth;
    }
}