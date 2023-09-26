class Solution {
    class Trie{
        HashMap<Character, Trie> children;
        String word;
        public Trie(){
            children = new HashMap<>();
            word = null;
        }
    }
    List<String> ans = new ArrayList<>();
    Trie root = new Trie();
    public List<String> findWords(char[][] board, String[] words) {
        for(String word : words){
            Trie node = root;
            for(char c : word.toCharArray()){
                if(!node.children.containsKey(c)){
                    node.children.put(c, new Trie());
                }
                node = node.children.get(c);
            }
            node.word = word;
        }
        
        for(int row=0; row<board.length; row++){
            for(int col=0; col<board[0].length; col++){
                if(root.children.containsKey(board[row][col])){
                    boolean[][] visited = new boolean[board.length][board[0].length];
                    backtrack(row,col,root,board,visited);
                }
            }
        }
        
        return ans;
    }
    
    public void backtrack(int row, int col, Trie parent, char[][] board, boolean[][] visited){
        Trie node = parent.children.get(board[row][col]);
        
        if(node.word != null){
            ans.add(node.word);
            node.word = null;
        }
        
        int[] neighbor_x = new int[]{-1,0,1,0};
        int[] neighbor_y = new int[]{0,-1,0,1};
        
        visited[row][col] = true;
        
        for(int i=0; i<4; i++){
            int nextRow = row + neighbor_x[i];
            int nextCol = col + neighbor_y[i];
            
            if(isValid(nextRow,nextCol,board) && node.children.containsKey(board[nextRow][nextCol]) && !visited[nextRow][nextCol]){
                backtrack(nextRow,nextCol,node,board,visited);
            }
        }
        
        visited[row][col] = false;
    }
    
    public boolean isValid(int row, int col, char[][] board){
        if(row < 0 || row >= board.length || col < 0 || col >= board[0].length){
            return false;
        }
        return true;
    }
}