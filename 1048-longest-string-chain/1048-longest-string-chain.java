class Solution {
    public int longestStrChain(String[] words) {
        HashMap<String, Integer> memo = new HashMap<>();
        Set<String> uniques  = new HashSet<>();
        Collections.addAll(uniques,words);
        
        int max = 0;
        for(String word : words){
            max = Math.max(max, dfs(word, memo, uniques));
        }
        
        return max;
    }
    
    public int dfs(String word, Map<String,Integer> memo, Set<String> uniques){
        if(memo.containsKey(word)){
            return memo.get(word);
        }
        int maxLen = 1;
        StringBuilder sb = new StringBuilder(word);
        for(int i=0; i<sb.length(); i++){
            String newWord = sb.deleteCharAt(i).toString();
            if(uniques.contains(newWord)){
                int currLen = 1 + dfs(newWord, memo, uniques);
                maxLen = Math.max(maxLen, currLen);
            }
            sb.insert(i,word.charAt(i));
        }
        
        memo.put(word, maxLen);
        return memo.get(word);
    }
}