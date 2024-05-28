class Solution {
    public int equalSubstring(String s, String t, int maxCost) {
        int left=0;
        int max_len=0;
        int curr_cost=0;
        
        for(int right=0; right<s.length(); right++){
            int transform_cost = Math.abs(s.charAt(right)-t.charAt(right));
            curr_cost += transform_cost;
            if(curr_cost > maxCost){
                while(curr_cost > maxCost && left <= right){
                    curr_cost -= Math.abs(s.charAt(left)-t.charAt(left));
                    left++;
                }
            }
            
            max_len = Math.max(max_len, right-left+1);
        }
        
        return max_len;
    }
}