class Solution {
    class Trie{
        boolean isEndOfWord = false;
        Map<Character,Trie> links = new HashMap<>();
        
        public void insert(String word){
            Trie trie = this;
            for(char c : word.toCharArray()){
                if(trie.links.containsKey(c)){
                    trie = trie.links.get(c);
                }else{
                    trie.links.put(c, new Trie());
                    trie = trie.links.get(c);
                }
            }
            
            trie.isEndOfWord = true;
        }
        
        public String search(){
            Trie curr = this;
            
            if(links.size() > 1){
                return "";
            }
            
            StringBuilder sb = new StringBuilder();
            while(!curr.isEndOfWord){
                if(curr.links.size() > 1){
                    return sb.toString();
                }
                for(Map.Entry<Character, Trie> entry : curr.links.entrySet()){
                    sb.append(entry.getKey());
                    curr = entry.getValue();
                }
            }
            
            return sb.toString();
        }
    }
    
    Trie myTrie = new Trie();
    public String longestCommonPrefix(String[] strs) {
        for(String str : strs){
            myTrie.insert(str);
        }
        
        return myTrie.search();
    }
}