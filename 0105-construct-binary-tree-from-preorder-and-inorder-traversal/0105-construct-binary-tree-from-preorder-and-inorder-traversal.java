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
    HashMap<Integer,Integer> inorderMap;
    int preorderIndex;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        inorderMap = new HashMap<>();
        preorderIndex = 0;
        
        for(int i=0; i<preorder.length; i++){
            inorderMap.put(inorder[i],i);
        }
        
        return treeFromArray(preorder,0,preorder.length-1);
    }
    
    public TreeNode treeFromArray(int[] preorder, int left, int right){
        if(left > right){
            return null;
        }
        
        //process by preorder
        TreeNode node = new TreeNode(preorder[preorderIndex++]);
        //left and right subtree of node are determined by using inorder array
        node.left = treeFromArray(preorder,left,inorderMap.get(node.val)-1);
        node.right = treeFromArray(preorder,inorderMap.get(node.val)+1,right);
            
        return node;
    }
}