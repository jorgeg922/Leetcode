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
    int max_sum = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        
        traverse(root);
        return max_sum;
    }
    
    public int traverse(TreeNode node){
        if(node == null){
            return 0;
        }
       
        int left = Math.max(traverse(node.left),0);
        int right = Math.max(traverse(node.right),0);
        
        int currSubtree = node.val + left + right;
        
        max_sum = Math.max(max_sum, currSubtree);
        
        return Math.max(left,right) + node.val;
    }
}