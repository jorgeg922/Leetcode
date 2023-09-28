class Solution {
    public int[] sortArrayByParity(int[] nums) {
        int n = nums.length;
        int left = 0;
        int right = n-1;
        int[] sortedParity = new int[n];
        for(int i=0; i<n; i++){
            if(nums[i] % 2 == 0){
                sortedParity[left++] = nums[i];
            }else{
                sortedParity[right--] = nums[i];
            }
        }
        
        return sortedParity;
    }
}