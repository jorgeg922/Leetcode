class Solution {
    public int calculate(String s) {
        Stack<Integer> stack = new Stack<>();
        char operation = '+';
        int currentNumber = 0;
        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            
            if(Character.isDigit(c)){
                currentNumber = (currentNumber * 10) + (c - '0');
            }
            
            if(!Character.isDigit(c) && !Character.isWhitespace(c) || i == s.length()-1){
                switch(operation){
                    case '+':
                        stack.push(currentNumber);
                        break;
                    case '-':
                        stack.push(-currentNumber);
                        break;
                    case '*':
                        stack.push(stack.pop() * currentNumber);
                        break;
                    case '/':
                        stack.push(stack.pop() / currentNumber);
                        break;
                }
                currentNumber = 0;
                operation = c;
            }
        }
        
        int ans = 0;
        while(!stack.isEmpty()){
            ans += stack.pop();
        }
        
        return ans;
    }
}