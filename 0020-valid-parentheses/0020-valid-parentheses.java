class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        
        for(char c : s.toCharArray()){
            switch(c){
                case '{':
                case '[':
                case '(':
                    stack.push(c);
                    break;
                case '}':
                case ']':
                case ')':
                    if(stack.isEmpty() || !valid(stack, c)){
                        return false;
                    }
            }
        }
        
        if(stack.size() > 0){
            return false;
        }
        return true;
    }
    
    
    public boolean valid(Stack<Character> stack, char c){
        char top = stack.peek();
        if((c != ')' && top == '(') || (c!='}' && top == '{') || (c!=']' && top == '[')){
            return false;
        }
        
        stack.pop();
        return true;
    }
}