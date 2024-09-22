class Solution {
    int[][] obstacleGrid;
    int rows;
    int cols;
    int[][] visited;
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        this.obstacleGrid = obstacleGrid;
        this.rows = obstacleGrid.length;
        this.cols = obstacleGrid[0].length;
        this.visited = new int[rows][cols];
        for(int[] entry : visited){
            Arrays.fill(entry,-1);
        }
        if(obstacleGrid[rows-1][cols-1] == 1){
            return 0;
        }
        return dfs(rows-1,cols-1);
    }
    
    public int dfs(int row, int col){
        if(row == 0 && col == 0){
            return 1;
        }
        
        if(visited[row][col] != -1){
            return visited[row][col];
        }
        
        int uniquePaths = 0;
        if(row-1 >= 0 && obstacleGrid[row-1][col] != 1){
            uniquePaths += dfs(row-1,col);
        }
        
        if(col-1 >=0 && obstacleGrid[row][col-1] != 1){
            uniquePaths += dfs(row, col-1);
        }
        
        visited[row][col] = uniquePaths;
        return uniquePaths;
    }
}