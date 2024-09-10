class Solution {
    public String decodeString(String s) {
        Stack<Character> stack = new Stack<>();
        
        for(char c : s.toCharArray()){
            if(c == ']'){
                StringBuilder sb = new StringBuilder();
                while(!stack.isEmpty() && stack.peek() != '['){
                    sb.append(stack.pop());
                }
                stack.pop();
                StringBuilder ss = new StringBuilder();
                while(!stack.isEmpty() && Character.isDigit(stack.peek())){
                    ss.append(stack.pop());
                }
                int repetitions = Integer.parseInt(ss.reverse().toString());
                String tmp = sb.reverse().toString();
                String tmp2 = "";
                for(int i=0; i<repetitions; i++){
                    tmp2+=tmp;
                }
                
                for(char c1 : tmp2.toCharArray()){
                    stack.push(c1);
                }
            }else{
                stack.push(c);
            }
        }
        
        StringBuilder ans = new StringBuilder();
        while(!stack.isEmpty()){
         ans.append(stack.pop());   
        }
        
        return ans.reverse().toString();
    }
}