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
    public TreeNode invertTree(TreeNode root) {
        if(root == null){
            return root;
        }
        if(root.left == null && root.right == null){
            return root;
        }
        
        invert(root);
        
        return root;
    }
    
    public void invert(TreeNode node){
        if(node == null){
            return;
        }
        TreeNode left = node.left;
        TreeNode right = node.right;
        
        node.left = right;
        node.right = left;
        
        invert(node.left);
        invert(node.right);
    }
}