class Solution {
    public int myAtoi(String s) {
        s = s.trim();
        if(s.length() == 0){
            return 0;
        }
        int sign = 1;
        long ans = 0;
        
        if(s.charAt(0) == '-'){
            sign = -1;
        }
        
        int i = s.charAt(0) == '-' || s.charAt(0) == '+' ? 1 : 0;
        
        while(i < s.length()){
            char c = s.charAt(i);
            if(Character.isDigit(c)){
                ans = ans * 10 + c - '0';
            }else{
                break;
            }
            if(sign==-1 && -1*ans < Integer.MIN_VALUE){
                return Integer.MIN_VALUE;
            }
            if(sign==1 && ans>Integer.MAX_VALUE){
                return Integer.MAX_VALUE;
            }
            i++;
        }
        
        return (int)ans * sign;
        
    }
}