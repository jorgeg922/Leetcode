class Solution {
    int[][] neighbors = new int[][]{{1,0},{-1,0},{0,1},{0,-1}};
    public int numIslands(char[][] grid) {
        int ans = 0;
        int rows = grid.length;
        int cols = grid[0].length;
        
        boolean[][] visited = new boolean[rows][cols];
        
        for(int row=0; row<rows; row++){
            for(int col=0; col<cols; col++){
                if(grid[row][col] == '1' && !visited[row][col]){
                    dfs(row,col, grid, visited);
                    ans++;
                }        
            }
        }
        
        return ans;
    }
    
    public void dfs(int row, int col, char[][] grid, boolean[][] visited){
        if(row < 0 || row >= grid.length || col < 0 || col >= grid[0].length || visited[row][col] || grid[row][col] == '0'){
            return;
        }
        
        visited[row][col] = true;
        
        for(int[] neighbor : neighbors){
            int nextRow = row + neighbor[0];
            int nextCol = col + neighbor[1];
            
            dfs(nextRow, nextCol, grid, visited);
        }
    }
}