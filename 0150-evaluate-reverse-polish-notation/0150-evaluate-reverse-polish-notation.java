class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        int ans = 0;
        for(String token : tokens){
            switch(token){
                case "+":
                    int a = stack.pop();
                    int b = stack.pop();
                    ans = (a+b);
                    stack.push(ans);
                    break;
                case "-":
                    a = stack.pop();
                    b = stack.pop();
                    ans = (b-a);
                    stack.push(ans);
                    break;
                case "*":
                    a = stack.pop();
                    b = stack.pop();
                    ans = (a*b);
                    stack.push(ans);
                    break;
                case "/":
                    a = stack.pop();
                    b = stack.pop();
                    ans = (b/a);
                    stack.push(ans);
                    break;
                default:
                    stack.push(Integer.parseInt(token));
            }
        }
        
        return stack.pop();
    }
}