class Solution {
    List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        backtrack(candidates,target,0,new ArrayList<Integer>(),0);
        return ans;
    }
    
    public void backtrack(int[] candidates, int target, int currSum, ArrayList<Integer> currList, int index){
        if(currSum == target){
            ans.add(new ArrayList<>(currList));
            return;
        }
        
        if(currSum > target){
            return;
        }
        
        
        for(int i=index; i<candidates.length; i++){
            if (i > index && candidates[i] == candidates[i - 1])
                continue;
            if(currSum + candidates[i] <= target){
                
                    currList.add(candidates[i]);
                    backtrack(candidates, target, currSum+candidates[i],currList,i+1);
                    currList.remove(currList.size()-1);
                   
                               
            }    
        }
    }
}