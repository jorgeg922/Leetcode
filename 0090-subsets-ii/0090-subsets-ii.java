class Solution {
    List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        backtrack(0,nums,new ArrayList<Integer>());
        return ans;
    }
    
    public void backtrack(int index, int[] nums, List<Integer> subset){        
            ans.add(new ArrayList<Integer>(subset));
        
        
        for(int i=index; i<nums.length; i++){
            if(i != index && nums[i] == nums[i-1]){
              continue;  
            }
             
                subset.add(nums[i]);
                backtrack(i+1,nums,subset);
                subset.remove(subset.size()-1);
                
            
            
        }
    }
}