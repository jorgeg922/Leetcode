class Solution {
    class Trie{
        Map<Character, Trie> branch;
        boolean isEndOfString;

        public Trie(){
            branch = new HashMap<>();
            isEndOfString = false;
        }

        public void insertWord(String word){
            Trie currentTrie = this;

            for(char c : word.toCharArray()){
                if(currentTrie.branch.containsKey(c)){
                    currentTrie = currentTrie.branch.get(c);
                }else{
                    currentTrie.branch.put(c, new Trie());
                    currentTrie = currentTrie.branch.get(c);
                }
            }
            currentTrie.isEndOfString = true;
        }

        public String findLongestPrefix(){
            StringBuilder sb = new StringBuilder();
            Trie currentTrie = this;

            while(currentTrie.branch.size() == 1 && !currentTrie.isEndOfString){
                for(Map.Entry<Character, Trie> entry : currentTrie.branch.entrySet()){
                    sb.append(entry.getKey());
                    currentTrie = entry.getValue();
                }
            }

            return sb.toString();
        }
    }
    public String longestCommonPrefix(String[] strs) {
        Trie trie = new Trie();

        for(String s : strs){
            trie.insertWord(s);
        }

        return trie.findLongestPrefix();
    }
}