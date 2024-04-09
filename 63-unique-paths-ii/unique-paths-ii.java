class Solution {
    int seen[][];
    int[][] grid;
    int rows;
    int cols;
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {        
        grid = obstacleGrid;
        rows = obstacleGrid.length;
        cols = obstacleGrid[0].length;
        seen = new int[rows][cols];
        
         if(obstacleGrid[rows-1][cols-1] == 1){
            return 0;
        }
        
        for(int entry[] : seen){
            Arrays.fill(entry, -1);
        }
               
        return genPaths(rows-1,cols-1);
    }
    
    public int genPaths(int row, int col){
        if(row == 0 && col == 0){
            return 1;
        }
        
        if(seen[row][col] != -1){
            return seen[row][col];
        }
        
        int paths = 0;
        
        if(row - 1 >= 0 && grid[row-1][col] != 1){
            paths += genPaths(row-1, col);
        }
        
        if(col - 1 >= 0 && grid[row][col-1] != 1){
            paths += genPaths(row, col-1);
        }
        
        seen[row][col] = paths;
        return paths;
    }
}