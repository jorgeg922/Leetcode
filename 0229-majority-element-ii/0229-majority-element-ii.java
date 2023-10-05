class Solution {
    public List<Integer> majorityElement(int[] nums) {
        Integer num1 = null;
        int count1 = 0;
        Integer num2 = null;
        int count2 = 0;
        
        for(int num : nums){
            if(num1 != null && num1 == num){
                count1++;
            }else if(num2 != null && num2 == num){
                count2++;
            }else if(count1 == 0){
                num1 = num;
                count1++;
            }else if(count2 == 0){
                num2 = num;
                count2++;
            }else{
                count1--;
                count2--;
            }
        }
        
        count1 = 0;
        count2 = 0;
        
        for(int num : nums){
            if(num1 != null && num1 == num){
                count1++;
            }else if(num2 != null && num2 == num){
                count2++;
            }
        }
        
        List<Integer> ans = new ArrayList<>();
        if(count1 > nums.length/3){
            ans.add(num1);
        }
        if(count2 > nums.length/3){
            ans.add(num2);
        }
        return ans;
    }
}