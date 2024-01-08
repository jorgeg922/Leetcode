class Solution {
    public String longestPalindrome(String s) {
        if(s.length() == 1){
            return s;
        }
        
        char[] sc = s.toCharArray();
        int max_len = Integer.MIN_VALUE;
        int start =0;
        int end =0;
        for(int i=0; i<sc.length; i++){
            int len1 = expandAroundCenter(i, i, s);
            int len2 = expandAroundCenter(i,i+1,s);
            int len = Math.max(len1,len2);
            
            if(len > max_len){
                start = i -(len-1)/2;
                end = i+len/2;
                //end = start + (len-1);
                max_len = len;
            }
        }
        
        return s.substring(start,end+1);
    }
    
    public int expandAroundCenter(int left, int right, String s){
        
        while(left >= 0 && right <s.length() && s.charAt(left) == s.charAt(right)){
            left--;
            right++;
        }
        
        return right-left-1;
    }
}