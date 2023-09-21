class Solution {
    List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        backtrack(0,candidates,target,new ArrayList<Integer>());
        return ans;
    }
    
    public void backtrack(int index, int[] candidates, int remain, List<Integer> subset){
        if(remain == 0){
            ans.add(new ArrayList<Integer>(subset));
            return;
        }
        if(remain < 0){
            return;
        }
        
        for(int i=index; i<candidates.length; i++){
            if(remain - candidates[i] >= 0){
                subset.add(candidates[i]);
                
                backtrack(i,candidates,remain-candidates[i], subset);
               
                subset.remove(subset.size()-1);
            }
        }
    }
}