class FileSystem {
    HashMap<String,Integer> existingPaths;
    public FileSystem() {
        existingPaths = new HashMap<>();
    }
    
    public boolean createPath(String path, int value) {
        if(path.isBlank() || path.equals("/")){
            return false;
        }
        
        if(existingPaths.containsKey(path)){
            return false;
        }
        
        int i = path.lastIndexOf("/");
        String tmp = path.substring(0,i);
        if(tmp.length() > 1 && !existingPaths.containsKey(tmp)){
            return false;
        }
                    
        existingPaths.put(path,value);
        return true;
        
    }
    
    public int get(String path) {
        if(existingPaths.containsKey(path)){
            return existingPaths.get(path);
        }
        return -1;
    }
}

/**
 * Your FileSystem object will be instantiated and called as such:
 * FileSystem obj = new FileSystem();
 * boolean param_1 = obj.createPath(path,value);
 * int param_2 = obj.get(path);
 */