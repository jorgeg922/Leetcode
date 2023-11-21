class Solution {
    public int countNicePairs(int[] nums) {
        int mod = (int)Math.pow(10,9) + 7;
        HashMap<Long, Integer> seen = new HashMap<>();
        int nicePairs = 0;
        
        for(int i=0; i<nums.length; i++){
            long rval = reverse(nums[i]);
            long target = nums[i] - rval;
            if(seen.containsKey(target)){
                nicePairs = (nicePairs%mod + seen.get(target)%mod)%mod;
            }            
            seen.put(target, seen.getOrDefault(target,0)+1);
        }
        
        return nicePairs;
    }
    
    
    public long reverse(int num){
        long r = 0;
        while(num != 0){
            r = (r * 10) + (num % 10);
            num = num/10;
        }
        
        return r;
    }
}