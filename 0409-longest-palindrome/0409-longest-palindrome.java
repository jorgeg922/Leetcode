class Solution {
    public int longestPalindrome(String s) {
        HashMap<Character, Integer> freq = new HashMap<>();
        
        boolean odd = false;
        int maxLen = 0;
        
        for(char c : s.toCharArray()){
            freq.put(c, freq.getOrDefault(c,0)+1);
        }
        
        for(Map.Entry<Character,Integer> entry : freq.entrySet()){
            int repetitions = entry.getValue();
            if(repetitions % 2 == 1){
                if(!odd){
                    maxLen += repetitions;
                    odd = true;
                }else{
                    maxLen += repetitions - 1;
                }
            }else{
                maxLen += repetitions;
            }
        }
        
        return maxLen;
    }
}