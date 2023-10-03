class Solution {
    String word;
    public boolean exist(char[][] board, String word) {
        this.word = word;    
        for(int row=0; row<board.length; row++){        
            for(int col=0; col<board[0].length; col++){            
                if(board[row][col] == word.charAt(0)){               
                    if(backtrack(row, col, board, 0, new boolean[board.length][board[0].length])){
                        return true;
                    }
                }
            }
        }
        
        return false;
    }
    
    public boolean backtrack(int row, int col, char[][] board, int index, boolean[][] visited){
        if(index >= word.length()-1){
            return true;
        }
        
        int[] x = {-1,0,1,0};
        int[] y = {0,-1,0,1};
        
        visited[row][col] = true;
        
        for(int i=0; i<4; i++){
            int nextRow = row + x[i];
            int nextCol = col + y[i];
            
            if(nextRow < 0 || nextRow >= board.length || nextCol < 0 || nextCol >= board[0].length || visited[nextRow][nextCol]){
                continue;
            }
            
            if(board[nextRow][nextCol] == word.charAt(index+1)){
                
                if(backtrack(nextRow,nextCol,board,index+1,visited)){
                    return true;
                }
            }
        }
        
        visited[row][col] = false;
        return false;
    }
}