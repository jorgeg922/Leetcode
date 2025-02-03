class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> seen = new HashSet<>();

        int maxLen = Integer.MIN_VALUE;

        int left = 0;
        for(int right=0; right<s.length(); right++){
            char c = s.charAt(right);
            if(seen.contains(c)){
                while(seen.contains(c) && left < right){
                    seen.remove(s.charAt(left));
                    left++;
                }
            }

            seen.add(s.charAt(right));

            maxLen = Math.max(maxLen, right-left+1);

        }

        return maxLen==Integer.MIN_VALUE?0:maxLen;
    }
}