class Solution {
    public String removeDuplicateLetters(String s) {
        HashMap<Character, Integer> lastOcurrence = new HashMap<>();
        for(int i=0; i<s.length(); i++){
            lastOcurrence.put(s.charAt(i),i);
        }
        
        Set<Character> seen = new HashSet<>();
        Stack<Character> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        
        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            if(!seen.contains(c)){
                while(!stack.isEmpty() && c < stack.peek() && lastOcurrence.get(stack.peek()) > i){
                    seen.remove(stack.pop());
                }
                stack.push(c);
                seen.add(c);
            }
           
        }
        
        while(!stack.isEmpty()){
            sb.append(stack.pop());
        }
        
        return sb.reverse().toString();
        
    }
}