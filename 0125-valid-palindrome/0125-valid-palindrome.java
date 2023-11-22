class Solution {
    public boolean isPalindrome(String s) {
        String sl = s.toLowerCase();
        StringBuilder sb = new StringBuilder();
        
        for(char c : sl.toCharArray()){
            if(Character.isLetterOrDigit(c)){
                sb.append(c);
            }
        }
        
        int left = 0;
        int right = sb.length()-1;
        
        while(left < right){
            char leftc = sb.charAt(left);
            char rightc = sb.charAt(right);
            
            if(leftc != rightc){
                return false;
            }
            
            left++;
            right--;
        }
        
        return true;
    }
}