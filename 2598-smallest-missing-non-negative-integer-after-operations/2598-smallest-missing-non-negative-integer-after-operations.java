class Solution {
    public int findSmallestInteger(int[] nums, int value) {
        int len = nums.length;
        Map<Integer,Integer> count = new HashMap<>();
        
        for(int num : nums){
            int mod = num % value;
            if(mod < 0){
                mod += value;
            }
            
            count.put(mod, count.getOrDefault(mod,0)+1);
        }
        
        
        for(int i=0;i<len;i++){
            int smallInt = i%value;
            if(!count.containsKey(smallInt)){
                return i;
            }
            
            count.put(smallInt,count.get(smallInt)-1);
            if(count.get(smallInt)==0){
                count.remove(smallInt);
            }
        }
        
        return len;
    }
}