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
    PriorityQueue<Integer> pq;
    int k;
    public int kthSmallest(TreeNode root, int k) {
        pq = new PriorityQueue<>((a,b) -> b-a);
        this.k = k;
        dfs(root);
        return pq.poll();
        
    }
    
    public void dfs(TreeNode node){
        if(node == null){
            return;
        }
        
        pq.add(node.val);
        if(pq.size() > k){
            pq.poll();
        }
        dfs(node.left);
        dfs(node.right);
    }
}