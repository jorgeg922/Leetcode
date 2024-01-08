class Solution {
    public String longestPalindrome(String s) {
        if(s.length() <= 1){
            return s;
        }
        
        int max_len = 0;
        String longest = "";
        for(int i=0; i<s.length(); i++){
            int len1 = expandAroundCenter(i,i,s);
            int len2 = expandAroundCenter(i,i+1,s);
            
            int len = Math.max(len1,len2);
            
            if(len > max_len){
                max_len = len;
                int start = i - (len-1)/2;
                int end = i + len/2;
                longest = s.substring(start,end+1);
            }
        }
        
        return longest;
    }
    
    public int expandAroundCenter(int left, int right, String s){
        while(left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)){
            left--;
            right++;
        }
        
        return right-left-1;
    }
}