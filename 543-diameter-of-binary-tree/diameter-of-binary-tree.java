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
    int maxDiameter = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        findDiameter(root);
        return maxDiameter;
    }

    public int findDiameter(TreeNode node){
        if(node == null){
            return 0;
        }

        int nodeToRight = findDiameter(node.right);
        int nodeToLeft = findDiameter(node.left);

        maxDiameter = Math.max(maxDiameter, nodeToRight + nodeToLeft);

        return Math.max(nodeToRight , nodeToLeft) +1;

    }
}