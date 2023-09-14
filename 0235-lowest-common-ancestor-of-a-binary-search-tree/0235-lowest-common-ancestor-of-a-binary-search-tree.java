/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null){
            return null;
        }
        return findAncestor(root,p,q);
    }
    
    public TreeNode findAncestor(TreeNode node, TreeNode p, TreeNode q){
        if(node == null){
            return null;
        }
        
        int currVal = node.val;
        
        if(p.val < currVal && q.val < currVal){
            return findAncestor(node.left,p,q);
        }else if(p.val > currVal && q.val > currVal){
            return findAncestor(node.right, p, q);
        }else{
            return node;
        }
    }
}