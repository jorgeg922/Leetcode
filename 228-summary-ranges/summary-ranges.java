class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> ans = new ArrayList<>(); 
        if(nums.length <= 0){
            return ans;
        }
        int left = 0;
        int right = 1;
        for(right=1; right<nums.length; right++){
            if(nums[right] == nums[right-1]+1){
                continue;
            }
           
            if(right-left==1){
                ans.add(""+nums[left]);
                left=right;
            }else{
                ans.add(""+nums[left]+"->"+nums[right-1]);
                left =right;
            }
        }
        
        if(left != right){
            if(right-1==left){
                ans.add(""+nums[left]);
            }else{
                ans.add(""+nums[left]+"->"+nums[right-1]);
            }
        }
        return ans;
    }
}