class Solution {
    public String addSpaces(String s, int[] spaces) {
        int currentSpace = 0;
        int ptr = 0;
        
        StringBuilder sb = new StringBuilder();
        
        while(ptr < s.length()){
            if(currentSpace < spaces.length){
                sb.append(s.substring(ptr, spaces[currentSpace]));
                sb.append(" ");
                ptr = spaces[currentSpace];
                currentSpace++;
               
            }else{
                sb.append(s.substring(ptr));
                break;
            }
        }
        
        return sb.toString();
        
    }
}