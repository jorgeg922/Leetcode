class Solution {
    public int minOperations(String[] logs) {
        Stack<String> stack = new Stack<>();
        
        for(String operation : logs){
            switch(operation){
                case "../":
                    if(!stack.isEmpty()){
                        stack.pop();
                    }
                    break;
                case "./":
                    break;
                default:
                    stack.push(operation);
                    break;
            }
        }
        
        return stack.size();
    }
}