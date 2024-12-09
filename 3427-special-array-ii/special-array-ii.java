class Solution {
    public boolean[] isArraySpecial(int[] nums, int[][] queries) {
        boolean[] ans = new boolean[queries.length];
        List<Integer> violatingIndeces = new ArrayList<>();
        
        for(int i=1; i<nums.length; i++){
            if(nums[i]%2 == nums[i-1]%2){
                violatingIndeces.add(i);
            }
        }
        
        for(int i=0; i<queries.length; i++){
            int[] query = queries[i];
            int start = query[0];
            int end = query[1];
            
            boolean foundViolatingIndex = binarySearch(start+1, end, violatingIndeces);
            
            if(foundViolatingIndex){
                ans[i] = false;
            }else{
                ans[i] = true;
            }
        }
        
        return ans;
    }
    
    public boolean binarySearch(int start, int end, List<Integer> violatingIndeces){
        int left = 0;
        int right = violatingIndeces.size()-1;
        
        while(left <= right){
            int mid = left + (right-left)/2;
            int violatingIndex = violatingIndeces.get(mid);
            
            if(violatingIndex < start){
                left = mid + 1;
            }else if(violatingIndex > end){
                right = mid -1;
            }else{
                return true;
            }
        }
        
        return false;
    }
}