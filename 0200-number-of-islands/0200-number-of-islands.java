class Solution {
    public int numIslands(char[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        
        boolean[][] visited = new boolean[rows][cols];
        int numberOfIslands = 0;
        for(int row=0; row<rows; row++){
            for(int col=0; col<cols; col++){
                if(grid[row][col]=='1' && !visited[row][col]){
                    dfs(row,col,grid,visited);
                    numberOfIslands++;
                }
            }
        }
        
        return numberOfIslands;
    }
    
    public void dfs(int row, int col, char[][] grid, boolean[][] visited){
        if(row<0 || row >= grid.length || col < 0 || col >= grid[0].length || visited[row][col] || grid[row][col] == '0'){
            return;
        }
        
        visited[row][col] = true;
        
        dfs(row+1,col,grid,visited);
        dfs(row-1,col,grid,visited);
        dfs(row,col+1,grid,visited);
        dfs(row,col-1,grid,visited);
    }
}