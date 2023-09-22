class Solution {
    public boolean isSubsequence(String s, String t) {
        if(s.length() == 0){
            return true;
        }
        if(t.length() < s.length()){
            return false;
        }
        
        int needle = 0;
        
        for(int haystack =0; haystack < t.length(); haystack++){
            char curr = t.charAt(haystack);
            if(curr == s.charAt(needle)){
                needle++;
            }
            
            if(needle == s.length()){
                return true;
            }
        }
        
        return false;
    }
}