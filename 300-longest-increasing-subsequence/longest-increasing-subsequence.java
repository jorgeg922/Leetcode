class Solution {
    HashMap<Integer,Integer> memo = new HashMap<>();
    public int lengthOfLIS(int[] nums) {
        int longest = 0;
        for(int i=0; i<nums.length; i++){
            longest = Math.max(longest, dp(i,nums));
        }
        return longest;
    }

    public int dp(int index, int[] nums){
        if(memo.containsKey(index)){
            return memo.get(index);
        }

        int len = 1;

        for(int i=0; i<index; i++){
            if(nums[i] < nums[index]){
                len = Math.max(len, dp(i,nums) + 1);
            }
        }

        memo.put(index, len);
        return len;
    }
}