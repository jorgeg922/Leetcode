class Solution {
    int[][] locations = {{1,0},{-1,0},{0,1},{0,-1}};
    char[][] grid;
    int rows;
    int cols;
    public int numIslands(char[][] grid) {
        int num_islands = 0;
        this.grid = grid;
        rows = grid.length;
        cols = grid[0].length;
        boolean[][] visited = new boolean[rows][cols];
        
        for(int row=0; row<rows; row++){
            for(int col=0; col<cols; col++){
                if(grid[row][col] == '1' && !visited[row][col]){
                    num_islands++;
                    dfs(row, col, visited);
                }
            }
        }
        
        return num_islands;
        
    }
    
    public void dfs(int row, int col, boolean[][] visited){
        if(row < 0 || row >= rows || col < 0 || col >= cols || visited[row][col] || grid[row][col] == '0'){
            return;
        }
        
        visited[row][col] = true;
        for(int[] location : locations){
            int nextRow = row + location[0];
            int nextCol = col + location[1];
            dfs(nextRow, nextCol, visited);
        }
    }
}