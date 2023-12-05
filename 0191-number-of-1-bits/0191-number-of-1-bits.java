public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {        
        String s = Integer.toBinaryString(n);
        int ans = 0;
        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            if(c == '1'){
                ans++;
            }
        }
        
        return ans;
    
    }
}