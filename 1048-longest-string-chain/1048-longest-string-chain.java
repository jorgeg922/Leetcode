class Solution {
    public int longestStrChain(String[] words) {
        Map<String,Integer> memo = new HashMap<>();
        Set<String> wordsPresent = new HashSet<>();
        Collections.addAll(wordsPresent, words);
        int longestChain = 0;
        for(String word : words){
            longestChain = Math.max(longestChain, dfs(wordsPresent,memo,word));
        }
        return longestChain;
    }
    
    public int dfs(Set<String> words, Map<String,Integer> memo, String currentWord){
        if(memo.containsKey(currentWord)){
            return memo.get(currentWord);
        }
        int maxLen = 1;
        StringBuilder sb = new StringBuilder(currentWord);
        
        for(int i=0; i<currentWord.length(); i++){
            sb.deleteCharAt(i);
            String newWord = sb.toString();
            
            if(words.contains(newWord)){
                int currentLen = 1 + dfs(words,memo,newWord);
                maxLen = Math.max(maxLen,currentLen);
            }
            sb.insert(i,currentWord.charAt(i));
        }
        memo.put(currentWord, maxLen);
        
        return maxLen;
    }
}