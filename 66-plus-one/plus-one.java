class Solution {
    public int[] plusOne(int[] digits) {

        int len = digits.length;
        int[] ans = new int[len+1];;
        

        int ptr = ans.length - 1;
        int add = 1;

        for(int i=len-1; i>=0; i--){
            int newDigit = (digits[i] + add) % 10;
            add = (digits[i] + add) / 10;
            ans[ptr--] = newDigit;
        }

        if(add != 0){
            ans[ptr--] = add;
        }

        return ans[0] == 0 ? Arrays.copyOfRange(ans, 1, ans.length) : ans; 

    }
}