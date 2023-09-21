class Trie {
    class Node{
        HashMap<Character, Node> children;
        boolean isEndOfWord;
        public Node(){            
            children = new HashMap<>();
            isEndOfWord = false;
        }
    }
    
    Node root;
    public Trie() {
        root = new Node();
    }
    
    public void insert(String word) {
        Node node = root;
        for(int i=0; i<word.length(); i++){
            if(!node.children.containsKey(word.charAt(i))){
               node.children.put(word.charAt(i), new Node()); 
            }           
            node = node.children.get(word.charAt(i));
        }
        
        node.isEndOfWord = true;
    }
    
    public boolean search(String word) {
       
        Node node = root;
        for(int i=0; i<word.length(); i++){
            char target = word.charAt(i);
            if(node.children.containsKey(target)){
                node = node.children.get(target);
            }else{
                return false;
            }            
        }
        
        return node.isEndOfWord;
        
    }
    
    public boolean startsWith(String prefix) {
        
        Node node = root;
        
        for(int i=0; i<prefix.length(); i++){
            if(!node.children.containsKey(prefix.charAt(i))){
                return false;
            }
            
            node = node.children.get(prefix.charAt(i));
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