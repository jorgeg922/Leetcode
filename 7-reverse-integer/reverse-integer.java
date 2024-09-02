class Solution {
    public int reverse(int x) {
        int num = x;
        long reversed = 0;
        
        while(num != 0){
            int rightDigit = num%10;
            num/=10;
            reversed = reversed*10 + rightDigit;   
        }
        
        if(reversed > Integer.MAX_VALUE || reversed < Integer.MIN_VALUE){
            return 0;
        }
        
        return (int) reversed;
    }
}