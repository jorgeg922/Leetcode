class Solution {
    int[][] grid;
    int rows;
    int cols;
    int[][] memo;
    public int minPathSum(int[][] grid) {
        this.grid = grid;
        rows = grid.length;
        cols = grid[0].length;
        memo = new int[rows][cols];
        for(int[] row : memo){
            Arrays.fill(row, Integer.MAX_VALUE);
        }
        
        return dp(0,0);
        
    }
    
    public int dp(int r, int c){
        if(r == rows-1 && c == cols-1){
            return grid[r][c];
        }
        
        if(r == rows || c == cols){
            return Integer.MAX_VALUE;
        }
        
        if(memo[r][c] != Integer.MAX_VALUE){
            return memo[r][c];
        }
        
        int value = grid[r][c];
        value += Math.min(
                    dp(r+1,c),dp(r,c+1)
        );
        
        memo[r][c] = value;
        return memo[r][c];
        
    }
}