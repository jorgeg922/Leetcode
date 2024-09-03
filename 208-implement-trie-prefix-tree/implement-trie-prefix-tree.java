class Trie {
    Map<Character,Trie> trie = new HashMap<>();
    boolean isEndOfWord = false;
    public Trie() {
        
    }
    
    public void insert(String word) {
        Trie curr = this;
        for(char c : word.toCharArray()){
            if(curr.trie.containsKey(c)){
                curr = curr.trie.get(c);
            }else{
                curr.trie.put(c, new Trie());
                curr = curr.trie.get(c);
            }
        }
        
        curr.isEndOfWord=true;
    }
    
    public boolean search(String word) {
        Trie curr = this;
        for(char c : word.toCharArray()){
            if(!curr.trie.containsKey(c)){
                return false;
            }
            curr = curr.trie.get(c);
        }
        
        return curr.isEndOfWord;
    }
    
    public boolean startsWith(String prefix) {
        Trie curr = this;
        for(char c : prefix.toCharArray()){
            if(!curr.trie.containsKey(c)){
                return false;
            }
            curr = curr.trie.get(c);
        }
        
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */