class Solution {
    public boolean canMakeSubsequence(String str1, String str2) {
        if(str2.length() > str1.length()){
            return false;
        }
        
        int ptr1=0;
        int ptr2=0;
        
        while(ptr1 < str1.length() && ptr2 < str2.length()){
            char current = str1.charAt(ptr1);
            char next = ' ';
            if(current == 'z'){
                next = 'a';
            }else{
                next = (char) (current + 1);
            }
            
            if(current == str2.charAt(ptr2) || next == str2.charAt(ptr2)){
                ptr2++;
            }
            
            ptr1++;
        }
        
        return ptr2==str2.length()?true:false;
        
        
    }
    
    
}