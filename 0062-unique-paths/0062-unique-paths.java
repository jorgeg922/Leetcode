class Solution {
    int rows;
    int cols;
    public int uniquePaths(int m, int n) {
        rows = m;
        cols = n;
        int[][] mem = new int[m][n];
    
        return dfs(m-1,n-1, mem);
    }
    
    public int dfs(int row, int col, int[][] mem){
        if(row == 0 && col == 0){
            return 1;
        }
        
        if(mem[row][col] != 0){
            return mem[row][col];
        }
        
        int ways = 0;
        
        if(row-1 >= 0){
            ways += dfs(row-1, col,mem);
        }
        if(col-1 >= 0){
            ways += dfs(row, col-1,mem);
        }
        
        mem[row][col] = ways;
        return ways;
    }
}