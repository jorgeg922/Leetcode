class Solution {
    int rows;
    int cols;
    int[][] board;
    public void gameOfLife(int[][] board) {
        this.board = board;
        rows = board.length;
        cols = board[0].length;
        int[][] newBoard = new int[rows][cols];
        
        for(int row=0; row<rows; row++){
            for(int col=0; col<cols; col++){
                simulate(row,col, newBoard);
            }
        }
        
        for(int row=0; row<rows; row++){
            for(int col=0; col<cols; col++){
                board[row][col]=newBoard[row][col];
            }
        }
    }
    
    
    public void simulate(int row, int col, int[][] newBoard){
        int[][] neighbors = new int[][]{{0,1},{0,-1},{1,0},{-1,0},{-1,-1},{-1,1},{1,1},{1,-1}};
        
        int live_neighbors = 0;
        
        for(int[] neighbor : neighbors){
            int nextRow = row + neighbor[0];
            int nextCol = col + neighbor[1];
            
            if(nextRow >= rows || nextRow < 0 || nextCol >= cols || nextCol < 0){
                continue;
            }
            
            if(board[nextRow][nextCol] == 1){
                live_neighbors++;
            }
        }
        
        if(board[row][col] == 0 && live_neighbors == 3){
            newBoard[row][col]=1;
            return;
        }
        
        if(board[row][col] == 1){
            if(live_neighbors < 2){
                newBoard[row][col] = 0;
            }else if(live_neighbors==2 || live_neighbors==3){
                newBoard[row][col] = 1;
            }else if(live_neighbors > 3){
                newBoard[row][col]=0;
            } 
        }
        
        
    }
    
    
}