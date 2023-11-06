class Solution {
    int rows;
    int cols;
    int[][] grid;
    int[][] memo;
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        
        this.grid = obstacleGrid;
        rows = grid.length;
        cols = grid[0].length;
        if(grid[rows-1][cols-1] == 1){
            return 0;
        }
        memo = new int[rows][cols];
        for(int[] row : memo){
            Arrays.fill(row,-1);
        }
        return dfs(rows-1,cols-1);
    }
    
    public int dfs(int row, int col){
        if(row == 0 && col == 0){
            return 1;
        }
        
        if(memo[row][col] != -1){
            return memo[row][col];
        }
        
        int paths = 0;
        if(row-1 >= 0 && grid[row-1][col] != 1){
            paths += dfs(row-1,col);
        }
        
        if(col-1 >=0 && grid[row][col-1] != 1){
            paths += dfs(row, col-1);
        }
        
        memo[row][col] = paths;
        return memo[row][col];
    }
}