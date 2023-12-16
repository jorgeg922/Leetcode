class Solution {
    public int lengthOfLongestSubstring(String s) {
        
        int left = 0;
        int maxLen = 0;
        Set<Character> seen = new HashSet<>();
        
        for(int right=0; right<s.length(); right++){
            char c = s.charAt(right);
            if(!seen.contains(c)){
                seen.add(c);
            }else{
                while(seen.contains(c)){
                    seen.remove(s.charAt(left));
                    left++;
                }
                seen.add(c);
            }
            
            maxLen = Math.max(maxLen, right-left+1);
        }
        
        return maxLen;
    }
}