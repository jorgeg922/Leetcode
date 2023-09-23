class WordDictionary {
    class Node{
        HashMap<Character, Node> children;        
        boolean isEndOfWord;
        
        public Node(){
            children = new HashMap<>();
            isEndOfWord = false;
            
        }
    }
    
    Node root;
    public WordDictionary() {
        root = new Node();
    }
    
    public void addWord(String word) {
        Node curr = root;
        for(char c : word.toCharArray()){
            if(!curr.children.containsKey(c)){
                curr.children.put(c, new Node());
            }
            curr = curr.children.get(c);
        }
        
        curr.isEndOfWord = true;
    }
    
    public boolean search(String word) {
        return searchInNode(word,root);
        
    }
    
    public boolean searchInNode(String word, Node node){
        for(int i=0; i<word.length(); i++){
            char c = word.charAt(i);
            if(!node.children.containsKey(c)){
                if(c == '.'){
                     for(char child : node.children.keySet()){
                        Node newNode = node.children.get(child);
                        if(searchInNode(word.substring(i+1),newNode)){
                            return true;
                        }
                    }
                }
                
                return false;
            }
            else{
                node = node.children.get(c);
            }
        }
        
        return node.isEndOfWord;
    }
    
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */