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
    public boolean isBalanced(TreeNode root) {
        if(root == null){
            return true;
        }
        if(root.left == null && root.right == null){
            return true;
        }
        
        int leftHeight = findHeight(root.left);
        int rightHeight = findHeight(root.right);
        
        if(Math.abs(leftHeight-rightHeight)>1){
            return false;
        }
        
        return isBalanced(root.left) && isBalanced(root.right);

    }
    
    public int findHeight(TreeNode node){
        if(node == null){
            return 0;
        }
        
        int height = 1;
        height += Math.max(findHeight(node.left),findHeight(node.right));
        
        return height;
    }
}