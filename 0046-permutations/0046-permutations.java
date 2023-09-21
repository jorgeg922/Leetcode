class Solution {
    List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> permute(int[] nums) {
        backtrack(nums, new ArrayList<Integer>());
        return ans;
    }
    
    public void backtrack(int[] nums, List<Integer> subset){
        if(subset.size() == nums.length){
            ans.add(new ArrayList<>(subset));
            return;
        }
        
        for(int i=0; i<nums.length; i++){
            if(!subset.contains(nums[i])){
                subset.add(nums[i]);
                backtrack(nums,subset);
                subset.remove(subset.size()-1);
            }           
        }
    }
}