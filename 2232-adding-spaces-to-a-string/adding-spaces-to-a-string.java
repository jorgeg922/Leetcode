class Solution {
    public String addSpaces(String s, int[] spaces) {
        int currentSpace = 0;
        
        StringBuilder sb = new StringBuilder();
        
        for(int i=0; i<s.length(); i++){
            if(currentSpace < spaces.length && i==spaces[currentSpace]){
                sb.append(" ");
                currentSpace++;
            }
            sb.append(s.charAt(i));
        }
        
        return sb.toString();
    }
}