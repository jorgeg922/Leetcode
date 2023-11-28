class Solution {
    public int longestPalindrome(String s) {
       Set<Character> set = new HashSet<>();
        
        for(char c : s.toCharArray()){
            if(set.contains(c)){
                set.remove(c);
            }else{
                set.add(c);
            }
        }
        
        if(set.size() < 1){
            return s.length();
        }
        
        return s.length() - set.size() + 1;
    }
}