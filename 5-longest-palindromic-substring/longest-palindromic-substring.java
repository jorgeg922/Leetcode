class Solution {
    String s;
    public String longestPalindrome(String s) {
        this.s = s;
        if(s.length() == 1){
            return s;
        }
        
        int maxLen = Integer.MIN_VALUE;
        String maxPalindrome = "";
        for(int i=0; i<s.length(); i++){
            String pal = expandAroundCenter(i,i);
            String pal2 = expandAroundCenter(i,i+1);
            
            String tmpLongest = "";
            if(pal.length() > pal2.length()){
                tmpLongest = pal;
            }else{
                tmpLongest = pal2;
            }
            
            if(tmpLongest.length() > maxLen){
                maxPalindrome = tmpLongest;
                maxLen = tmpLongest.length();
            }
        }
        
        
        return maxPalindrome;
    }
    
    
    public String expandAroundCenter(int left, int right){
        while(left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)){
            left--;
            right++;
        }
        
        return s.substring(left+1,right);
    }
}