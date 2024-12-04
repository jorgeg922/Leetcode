class Solution {
    public boolean canMakeSubsequence(String str1, String str2) {
        if(str2.length() > str1.length()){
            return false;
        }
        
        return findSubSequence(str1, 0, str2, 0);
        
    }
    
    public boolean findSubSequence(String str1, int index1, String str2, int index2){
        if(index2 == str2.length()){
            return true;
        }
        
        for(int i=index1; i<str1.length(); i++){
            char current = str1.charAt(i);
            char next = ' ';
            if(current == 'z'){
                next = 'a';
            }else{
                next = (char) (current + 1);
            }
            
            if(current == str2.charAt(index2) || next == str2.charAt(index2)){
                return findSubSequence(str1, i+1, str2, index2+1);
            }
        }
        
        return false;
    }
}