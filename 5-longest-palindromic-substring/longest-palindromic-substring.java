class Solution {
    public String longestPalindrome(String s) {
        int left = 0;
        int right = s.length()-1;
        int maxLen = Integer.MIN_VALUE;
        String ans = "";
        
        for(int i=0; i<s.length(); i++){
           
            String len1 = expandAroundCenter(i,i,s);
            String len2 = expandAroundCenter(i, i+1,s);
            
            String localMax = len1.length()>len2.length()?len1:len2;
            
            if(localMax.length() > maxLen){
                maxLen = localMax.length();
                ans = localMax;
            }

        }
        
        return ans;
    
    }
    
    public String expandAroundCenter(int left, int right, String s){
        while(left>=0 && right <=s.length()-1 && s.charAt(left) == s.charAt(right)){
            left--;
            right++;
        }
        
        return s.substring(left+1, right);
    }
}