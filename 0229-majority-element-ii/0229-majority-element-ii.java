class Solution {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        int ceiling = nums.length/3;
        HashMap<Integer,Integer> count = new HashMap<>();
        
        for(int num : nums){
            count.put(num,count.getOrDefault(num,0)+1);
        }
        
       for(Map.Entry<Integer,Integer> entry : count.entrySet()){
           if(entry.getValue() > ceiling){
               ans.add(entry.getKey());
           }
       }
        
        return ans;
    }
}