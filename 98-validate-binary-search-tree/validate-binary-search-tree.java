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
    public boolean isValidBST(TreeNode root) {
        return isValid(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public boolean isValid(TreeNode node, Long floor, Long ceiling){
        if(node == null){
            return true;
        }

        if(node.val <= floor || node.val >= ceiling){
            return false;
        }

        boolean left = isValid(node.left, floor, (long) node.val);
        boolean right = isValid(node.right,  (long) node.val, ceiling);

        return left && right;
    }
}