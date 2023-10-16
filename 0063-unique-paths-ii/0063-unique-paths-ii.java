class Solution {
    int rows;
    int cols;
    int[][] memo;
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        this.rows = obstacleGrid.length;
        this.cols = obstacleGrid[0].length;
        
        if(obstacleGrid[rows-1][cols-1]==1){
            return 0;
        }
        
        this.memo = new int[rows][cols];
        for(int[] memoRow : memo){
            Arrays.fill(memoRow,-1);
        }
        
        return dfs(rows-1,cols-1,obstacleGrid);
        
       
    }
    
    public int dfs(int row, int col, int[][] obstacleGrid){
        if(row==0 && col==0){
            return 1;
        }
        
        if(memo[row][col] > -1){
            return memo[row][col];
        }
        
        int paths = 0;
        
        int[][] directions = new int[][]{{-1,0},{0,-1}};
        
        for(int i=0; i<2; i++){
            int nextRow = row + directions[i][0];
            int nextCol = col + directions[i][1];
            
            if(nextRow < 0 || nextRow >= rows || nextCol < 0 || nextCol >= cols || obstacleGrid[nextRow][nextCol]==1){
                continue;
            }
            
            paths += dfs(nextRow,nextCol,obstacleGrid);
        }
        
        memo[row][col] = paths;
        return memo[row][col];
        
    }
}