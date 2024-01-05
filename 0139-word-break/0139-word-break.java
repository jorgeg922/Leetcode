class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        
        return findWords(0,s,wordDict, new Boolean[s.length()]);
    }
    
    public boolean findWords(int index, String s, List<String> wordDict, Boolean[] mem){
        if(index == s.length()){
            return true;
        }
        
        if(mem[index] != null){
            return false;
        }
        
        int left = index;
        
        for(int right = index+1; right<=s.length(); right++){
            if(wordDict.contains(s.substring(left,right)) && findWords(right, s, wordDict,mem)){
                return mem[index] = true;
            }
        }
        
        return mem[index] = false;
    }
}