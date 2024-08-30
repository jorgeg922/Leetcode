class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        
        for(char c : s.toCharArray()){
            switch(c){
                case '[':
                case '(':
                case '{':
                    stack.push(c);
                    break;
                case ')':
                case '}':
                case ']':
                    if(!validate(stack, c)){
                        return false;
                    }
                default:
                    break;
            }
        }
        
        if(!stack.isEmpty()){
            return false;
        }
        
        return true;
    }
    
    public boolean validate(Stack<Character> stack, char c){
        if(stack.isEmpty()){
            return false;
        }
        
        char top = stack.peek();
        if((top=='{' && c != '}') || (top=='(' && c != ')') || (top=='[' && c != ']')){
            return false;
        }
        
        stack.pop();
        return true;
    }
}