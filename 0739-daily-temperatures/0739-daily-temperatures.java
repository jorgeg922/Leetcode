class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] ans = new int[temperatures.length];
        Stack<Integer> stack = new Stack<>();
        
        for(int i=0; i<temperatures.length; i++){
            int temperature = temperatures[i];
            if(stack.isEmpty()){
                stack.push(i);
                continue;
            }
            
            if(temperatures[stack.peek()] > temperature){
                stack.push(i);
            }else{
                while(!stack.isEmpty() && temperatures[stack.peek()] < temperature){
                    int index = stack.pop();
                    ans[index] = i-index;
                }
                stack.push(i);
            }
        }
        
        
        return ans;
    }
}