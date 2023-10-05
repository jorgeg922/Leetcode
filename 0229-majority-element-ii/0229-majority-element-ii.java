class Solution {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        int n = nums.length;
        HashMap<Integer,Integer> count = new HashMap<>();
        
        for(int num : nums){
            count.put(num,count.getOrDefault(num,0)+1);
            if(count.get(num) > (n/3)+1){
                continue;
            }
            if(count.get(num) > n/3){
                ans.add(num);
            }
        }
        
        return ans;
    }
}