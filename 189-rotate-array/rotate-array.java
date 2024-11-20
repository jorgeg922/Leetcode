class Solution {
    public void rotate(int[] nums, int k) {
        int size = nums.length;
        int steps = 0;
        if(k > nums.length){
            steps = k%size;
        }else{
            steps = k;
        }
        
        if(steps == 0){
            return;
        }
        
        
        int currIndex = size - steps;
        boolean[] visited = new boolean[size];
        
        List<Integer> ans = new ArrayList<>();
        
        while(!visited[currIndex]){
            visited[currIndex] = true;
            ans.add(nums[currIndex]);
            currIndex++;
            if(currIndex >= size){
                currIndex = 0;
            }
        }
        
        for(int i=0; i<size; i++){
            nums[i]=ans.get(i);
        }
    }
}