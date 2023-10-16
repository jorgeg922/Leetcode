class Solution {
    public int singleNumber(int[] nums) {
        Set<Integer> uniqueNumber = new HashSet<>();
        
        for(int num : nums){
            if(uniqueNumber.contains(num)){
                uniqueNumber.remove(num);
            }else{
                uniqueNumber.add(num);
            }
        }
        
        for(int ans : uniqueNumber){
            return ans;
        }
        
        return -1;
    }
}