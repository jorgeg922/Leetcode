class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        int ans = 0;
        for(String token : tokens){
            if(!"/*-+".contains(token)){
                stack.push(Integer.parseInt(token));
                continue;
            }
            
            int a = stack.pop();
            int b = stack.pop();
            switch(token){
                case "+":                 
                    ans = (a+b);
                    break;
                case "-":
                    ans = (b-a);
                    break;
                case "*":                    
                    ans = (a*b);
                    break;
                case "/":
                    ans = (b/a);
                    break;
                default:
                    stack.push(Integer.parseInt(token));
            }
            stack.push(ans);
        }
        
        return stack.pop();
    }
}