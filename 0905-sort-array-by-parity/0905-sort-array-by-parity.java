class Solution {
    public int[] sortArrayByParity(int[] nums) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>(){
            public int compare(Integer a, Integer b){
                if(a%2==0 && b%2!=0){
                    return -1;
                }else if(a%2!=0 && b%2==0){
                    return 1;
                }else{
                    return a-b;
                }
            }
        });
        
        
        for(int num : nums){
            pq.add(num);
        }
        
        int[] ans = new int[nums.length];
        int i=0;
        while(!pq.isEmpty()){
            ans[i++]=pq.poll();
        }
        
        return ans;
    }
}