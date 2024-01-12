class Solution {
    public int calculate(String s) {
        int operand = 0;
        int n = 0;
        Stack<Object> stack = new Stack<Object>();
        
        for(int i=s.length()-1; i>=0; i--){
            char c = s.charAt(i);
            if(Character.isDigit(c)){
                operand = (int) Math.pow(10,n) * (int) (c - '0') + operand;
                n++;
            }else if(c != ' '){
                if(n != 0){
                   stack.push(operand);
                    n = 0;
                    operand = 0; 
                }
                if(c == '('){
                    int res = evaluateExpr(stack);
                    stack.pop();
                    stack.push(res);
                }else{
                    stack.push(c);
                }
            }
        }
        
        if(n != 0){
            stack.push(operand);
        }
        
        return evaluateExpr(stack);
    }
    
    public int evaluateExpr(Stack<Object> stack){
        if(stack.isEmpty() || !(stack.peek() instanceof Integer)){
            stack.push(0);
        }
        
        int res = (int) stack.pop();
        
        while(!stack.isEmpty() && !((char)stack.peek() == ')')){
            char sign = (char) stack.pop();
            
            if(sign == '+'){
                res += (int) stack.pop();
            }else{
                res -= (int) stack.pop();
            }
        }
        
        return res;
    }
}