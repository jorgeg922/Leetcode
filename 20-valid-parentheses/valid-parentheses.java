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
                default:
                    if(stack.isEmpty()){
                        return false;
                    }
                    if(!validEntry(c, stack)){
                        return false;
                    }else{
                        stack.pop();
                    }
                    
                    break;
            }
        }

        return stack.isEmpty();
    }

    public boolean validEntry(Character c, Stack<Character> stack){
        char top = stack.peek();

        if((top == '[' && c != ']') || (top=='{' && c != '}') || (top=='(' && c != ')')){
            return false;
        }

        return true;
    }
}