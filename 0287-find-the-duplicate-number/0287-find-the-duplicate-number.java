class Solution {
    public int findDuplicate(int[] nums) {
        Set<Integer> uniques = new HashSet<>();
        
        for(int num : nums){
            if(uniques.contains(num)){
                return num;
            }
            uniques.add(num);
        }
        
        return -1;
    }
}