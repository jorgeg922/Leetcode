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
    TreeNode p;
    List<TreeNode> inOrder;
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        inOrder = new ArrayList<>();
        this.p = p;
        traverse(root);
        for(int i=0; i<=inOrder.size()-2; i++){
            if(inOrder.get(i) == p){
                return inOrder.get(i+1);
            }
        }
        
        return null;
    }
    
    public void traverse(TreeNode node){
        if(node == null){
            return;
        }
        
        traverse(node.left);
        inOrder.add(node);
        traverse(node.right);
    }
}