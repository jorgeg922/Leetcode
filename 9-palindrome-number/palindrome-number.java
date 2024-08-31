class Solution {
    public boolean isPalindrome(int x) {
        String num = String.valueOf(x);
        
        if(num.charAt(0)=='-'){
            return false;
        }
        
        StringBuilder sb = new StringBuilder(num);
        sb.reverse();
        
        if(sb.toString().equals(num)){
            return true;
        }
        
        return false;
    }
}