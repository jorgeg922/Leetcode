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
    int count = 0;
    int k;
    HashMap<Long, Integer> map = new HashMap<>();
    public int pathSum(TreeNode root, int targetSum) {
        k = targetSum;
        preorder(root, 0L);
        return count;
    }
    
    public void preorder(TreeNode node, long currSum){
        if(node == null){
            return;
        }
        
        currSum += node.val;
        
        if(currSum == k){
            count++;
        }
        
        count += map.getOrDefault(currSum - k, 0);
        
        map.put(currSum, map.getOrDefault(currSum,0)+1);
        
        preorder(node.right, currSum);
        preorder(node.left, currSum);
        
        map.put(currSum, map.get(currSum)-1);
    }
}