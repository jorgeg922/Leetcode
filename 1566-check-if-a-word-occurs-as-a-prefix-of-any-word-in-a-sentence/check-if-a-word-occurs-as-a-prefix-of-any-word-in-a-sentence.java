class Solution {
    class Trie{
        int wordIndex;
        Map<Character, Trie> branch;
        
        public Trie(){
            wordIndex = Integer.MAX_VALUE;
            branch = new HashMap<>();
        }
        
        public void insertWord(String word, int index){
            Trie curr = this;
            for(char c : word.toCharArray()){
                if(curr.branch.containsKey(c)){
                    curr = curr.branch.get(c);
                }else{
                    Trie newBranch = new Trie();
                    curr.branch.put(c, newBranch);
                    curr = curr.branch.get(c);
                    curr.wordIndex = Math.min(curr.wordIndex, index);
                }
            }
            
            
        }
        
        public int searchPrefix(String prefix){
            Trie curr = this;
            
            for(char c : prefix.toCharArray()){
                if(!curr.branch.containsKey(c)){
                    return Integer.MAX_VALUE;
                }
                
                curr = curr.branch.get(c);
            }
            
            return curr.wordIndex;
        }
    }
    public int isPrefixOfWord(String sentence, String searchWord) {
        Trie trie = new Trie();
        String[] words = sentence.split(" ");
        
        for(int i=0; i<words.length; i++){
            String word = words[i];
            trie.insertWord(word,i);
        }
        
        int index = trie.searchPrefix(searchWord);
        return index!=Integer.MAX_VALUE?index+1:-1;
    }
}