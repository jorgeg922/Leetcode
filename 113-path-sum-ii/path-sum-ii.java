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
    List<List<Integer>> ans;
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) { 
        
        ans = new ArrayList<>();
        
        if(root == null){
            return ans;
        }
        
        List<Integer> currList = new ArrayList<>();
        currList.add(root.val);
        dfs(root, targetSum-root.val, currList);
        return ans;
    }
    
    public void dfs(TreeNode node, int remain, List<Integer> currList){        
        if(remain == 0){
            if(node.left == null && node.right == null){
                ans.add(new ArrayList<>(currList));               
            }
            //return;
        }
        
        if(node.left != null){ //&& remain-node.left.val >= 0){
            currList.add(node.left.val);
            dfs(node.left, remain-node.left.val, currList);
            currList.remove(currList.size()-1);
        }
        
        if(node.right != null){ //&& remain-node.right.val >= 0){
            currList.add(node.right.val);
            dfs(node.right, remain-node.right.val, currList);
            currList.remove(currList.size()-1);
        }
    }
}