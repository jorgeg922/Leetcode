class Solution {
    List<List<Integer>> ans = new ArrayList<>();
    Set<List<Integer>> tmp = new HashSet<>();
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        backtrack(candidates,target,0,new ArrayList<Integer>(),new HashSet<Integer>(),0);
        
        for(List<Integer> combination : tmp){
            ans.add(combination);
        }
        return ans;
    }
    
    public void backtrack(int[] candidates, int target, int currSum, ArrayList<Integer> currList, HashSet<Integer> set, int index){
        if(currSum == target){
            tmp.add(new ArrayList<>(currList));
            return;
        }
        
        if(currSum > target){
            return;
        }
        
        
        for(int i=index; i<candidates.length; i++){
            if (i > index && candidates[i] == candidates[i - 1])
                continue;
            if(currSum + candidates[i] <= target){
                if(!set.contains(i)){
                    set.add(i);
                    currList.add(candidates[i]);
                    backtrack(candidates, target, currSum+candidates[i],currList, set,i+1);
                    currList.remove(currList.size()-1);
                    set.remove(i);
                }                
            }    
        }
    }
}