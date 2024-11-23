class Solution {
    public int hammingWeight(int n) {
        int count = 0;
        String bin = Integer.toBinaryString(n);
        for(char c : bin.toCharArray()){
            if(c == '1'){
                count++;
            }
        }
        
        return count;
    }
}