class Solution {
    List<List<Integer>> ans = new ArrayList<List<Integer>>();
    public List<List<Integer>> subsets(int[] nums) {
        backtrack(0,nums, new ArrayList<Integer>());
        return ans;
    }
    
    public void backtrack(int index, int[] nums, List<Integer> subset){
        if(index > nums.length){
            return;
        }
        
        ans.add(new ArrayList<Integer>(subset));
        
        for(int i=index; i<nums.length; i++){
            subset.add(nums[i]);            
            backtrack(i+1,nums,subset);
            subset.remove(subset.size()-1);
        }
    }
}