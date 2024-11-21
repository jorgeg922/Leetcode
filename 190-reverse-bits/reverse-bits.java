public class Solution {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int reversed = 0;
        int bits = 31;
        
        while(n != 0){
            reversed += (n & 1) << bits;
            n = n >>> 1;
            bits -= 1;
        }
        
        return reversed;
    }
}