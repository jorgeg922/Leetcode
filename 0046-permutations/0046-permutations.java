class Solution {
    List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> permute(int[] nums) {
        backtrack(nums, new ArrayList<Integer>(), new HashSet<Integer>());
        return ans;
    }
    
    public void backtrack(int[] nums, List<Integer> subset, HashSet<Integer> set){
        if(subset.size() == nums.length){
            ans.add(new ArrayList<>(subset));
            return;
        }
        
        for(int i=0; i<nums.length; i++){
            if(!set.contains(nums[i])){
                set.add(nums[i]);
                subset.add(nums[i]);
                backtrack(nums,subset,set);
                set.remove(nums[i]);
                subset.remove(subset.size()-1);
            }           
        }
    }
}