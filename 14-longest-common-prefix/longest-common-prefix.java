class Solution {
    class Trie{
        Map<Character,Trie> links = new HashMap<>();
        boolean isEndOfWord = false;
        
        public void insert(String word){
            Trie curr = this;
            for(char c : word.toCharArray()){
                if(curr.links.containsKey(c)){
                    curr = curr.links.get(c);
                    continue;
                }
                curr.links.put(c, new Trie());
                curr = curr.links.get(c);
            }
            curr.isEndOfWord = true;
        }
        
        public String searchForLongestPrefix(){
            StringBuilder sb = new StringBuilder();
           
            Trie curr = this;
            
            while(!curr.isEndOfWord){
                if(curr.links.size() > 1){
                    return sb.toString();
                }
                for(Map.Entry<Character,Trie> link : curr.links.entrySet()){
                    sb.append(link.getKey());
                    if(curr.isEndOfWord){
                        return sb.toString();
                    }
                    curr = link.getValue();
                }
            }
            
            return sb.toString();
        }
        
    }
    public String longestCommonPrefix(String[] strs) {
        Trie trie = new Trie();
        for(String str : strs){
            trie.insert(str);
        }
        
        return trie.searchForLongestPrefix();
    }
}