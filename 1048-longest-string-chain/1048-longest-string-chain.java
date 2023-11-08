class Solution {
    int N;
    HashMap<String,Integer> memo;
    Set<String> wordsPresent;
    public int longestStrChain(String[] words) {
        N = words.length;
        memo = new HashMap<>();
        wordsPresent = new HashSet<>();
        
        
        for(String word : words){
            wordsPresent.add(word);
        }
    
        int maxChain = 0;
        for(String word : words){
            maxChain = Math.max(maxChain, dp(word));
        }
        
        return maxChain;
    }
    
    public int dp(String word){
        if(memo.containsKey(word)){
            return memo.get(word);
        }
        
        int maxChain = 1;
        StringBuilder sb = new StringBuilder(word);
        for(int i=0; i<word.length(); i++){
            String newWord = sb.deleteCharAt(i).toString();
            if(wordsPresent.contains(newWord)){
                maxChain = Math.max(maxChain, dp(newWord)+1);
            }
            sb.insert(i,word.charAt(i));
        }
        
        memo.put(word, maxChain);
        return maxChain;
        
    }
}