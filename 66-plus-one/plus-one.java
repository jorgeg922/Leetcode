class Solution {
    public int[] plusOne(int[] digits) {
        int len = digits.length;
        int carry = 1;
        for(int i=len-1; i>=0; i--){
            int newDigit = (digits[i] + carry) % 10;
            carry = (digits[i] + carry)/10;
            digits[i] = newDigit;

            if(carry == 0){
                return digits;
            }
        }

        
        int[] ans = new int[len+1];
        ans[0] = carry;
        for(int i=0; i<len; i++){
            ans[i+1] = digits[i];
        }
        return ans;
    

    }
}