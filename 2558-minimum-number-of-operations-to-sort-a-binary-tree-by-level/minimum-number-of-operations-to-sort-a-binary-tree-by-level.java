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
    public int minimumOperations(TreeNode root) {
        int swaps = 0;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        
        while(!q.isEmpty()){
            int size = q.size();
            int[] currLevel = new int[size];
            for(int i=0; i<size; i++){
                TreeNode curr = q.poll();
                
                if(curr.left != null){
                    q.add(curr.left);
                }
                
                if(curr.right != null){
                    q.add(curr.right);
                }
                currLevel[i] = curr.val;
            }
            
            swaps += getSwapsCount(currLevel);
        }
        
        return swaps;
    }
    
    public int getSwapsCount(int[] numbers){
        int swap=0;
        int[] sortedNumbers = numbers.clone();
        Arrays.sort(sortedNumbers);
        
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0; i<numbers.length; i++){
            map.put(numbers[i], i);
        }
        
        for(int i=0; i<numbers.length; i++){
            if(sortedNumbers[i] != numbers[i]){
                swap++;
                int currPos = map.get(sortedNumbers[i]);
                numbers[currPos] = numbers[i];
                map.put(numbers[i], currPos);
            }
        }
        
        return swap;
    }
}