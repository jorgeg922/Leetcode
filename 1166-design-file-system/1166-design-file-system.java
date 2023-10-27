class FileSystem {
    class Trie{
        String path;
        int value;
        HashMap<String,Trie> nodes;
        public Trie(String path){
            this.path = path;
            this.value = -1;
            nodes = new HashMap<>();
        }
    }
    
    Trie root;
    public FileSystem() {
        root = new Trie("");
    }
    
    public boolean createPath(String path, int value) {
        String[] folders = path.split("/");
        if(folders.length < 1){
            return false;
        }
        
        Trie paths = root;
        for(int i=1; i<folders.length-1; i++){
            String currFolder = folders[i];
            
            if(!paths.nodes.containsKey(currFolder)){
                return false;
            }
            
            paths = paths.nodes.get(currFolder);
        }
        
        String lastFolder = folders[folders.length-1];
        if(paths.nodes.containsKey(lastFolder)){
            return false;
        }
        
        Trie newFolder = new Trie(lastFolder);
        newFolder.value = value;
        paths.nodes.put(lastFolder,newFolder);
        return true;
        
        
        
    }
    
    public int get(String path) {
        String[] folders = path.split("/");
        Trie folder = root;
        
        for(int i=1; i<folders.length; i++){
            if(!folder.nodes.containsKey(folders[i])){
                return -1;
            }    
            folder = folder.nodes.get(folders[i]);
        }
        
        return folder.value;
        
    }
}

/**
 * Your FileSystem object will be instantiated and called as such:
 * FileSystem obj = new FileSystem();
 * boolean param_1 = obj.createPath(path,value);
 * int param_2 = obj.get(path);
 */