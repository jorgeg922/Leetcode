class Solution {
    Set<List<Integer>> uniques;
    int target;
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        uniques = new HashSet<>();
        this.target = target;
        findCombinations(candidates,0,0, new ArrayList<Integer>());
        
        List<List<Integer>> ans = new ArrayList<>();
        for(List<Integer> set : uniques){
            ans.add(set);
        }
        return ans;
    }
    
    public void findCombinations(int[]candidates, int index, int sum, List<Integer> numList){
        if(sum == target){
            uniques.add(new ArrayList<>(numList));
            return;
        }
        
        for(int i=index; i<candidates.length; i++){
            if(i>index && candidates[i]==candidates[i-1]){
                continue;
            }
            if(sum+candidates[i] > target){
                continue;
            }
           
           
            numList.add(candidates[i]);
            findCombinations(candidates, i+1, sum+candidates[i],numList);
            numList.remove(numList.size()-1);
        }
    }
}