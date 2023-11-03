class Solution {
    public int findSmallestInteger(int[] nums, int value) {
        int len = nums.length;
        HashMap<Integer,Integer> count = new HashMap<>();
        
        //convert values to the mininum positive value, and log frequency
        for(int i=0; i<len; i++){
            int mod = nums[i] % value;
            if(mod < 0){
                mod += value;
            }
            count.put(mod,count.getOrDefault(mod,0)+1);
        }
        
        //map above is keeping track of how many mins of a kind you can make
        //now use the "index" to see if you could have made that number
        for(int i=0; i<len; i++){
            int check = i % value;
            if(!count.containsKey(check) || count.get(check) == 0){
                return i;
            }
            
            count.put(check,count.get(check)-1);
        }
        
        return nums.length;
    }
}