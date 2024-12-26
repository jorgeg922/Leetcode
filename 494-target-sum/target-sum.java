class Solution {
    int[] nums;
    int target;
    char[] choices = new char[]{'-','+'};
    
    Map<String, Integer> memo;
    public int findTargetSumWays(int[] nums, int target) {
        this.nums = nums;
        this.target = target;
        memo = new HashMap<>();
       
        int ways=findWays(0, 0);
        return ways;
    }
    
    public int findWays(int index, int sum){
        if(index == nums.length){
            return sum == target ? 1 : 0;
        }
        
        String key = index + "," + sum;
        
        if(memo.containsKey(key)){
            return memo.get(key);
        }
        
        int ways = 0;
        for(int choice : choices){
            
            switch(choice){
                case '-':
                    sum += (nums[index] * -1);
                    ways += findWays(index+1, sum);
                    sum -= (nums[index] * -1);
                    break;
                case '+':
                    sum += (nums[index]);
                    ways += findWays(index+1, sum);
                    sum -= (nums[index] * -1);
                    break;
            }      
            
        }
        
        memo.put(key, ways);
        return ways;
        
    }
}