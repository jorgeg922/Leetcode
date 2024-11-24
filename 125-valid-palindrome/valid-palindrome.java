class Solution {
    public boolean isPalindrome(String s) {       
        String sc = s.toLowerCase();
        int left=0;
        int right=sc.length()-1;
        
        while(left < right){
            if(!Character.isLetterOrDigit(sc.charAt(left))){
                left++;
                continue;
            }
            
            if(!Character.isLetterOrDigit(sc.charAt(right))){
                right--;
                continue;
            }
            
            if(sc.charAt(left) != sc.charAt(right)){
                return false;
            }
            
            left++;
            right--;
        }
        
        return true;
    }
}