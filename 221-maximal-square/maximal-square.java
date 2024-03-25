class Solution {
    public int maximalSquare(char[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int maxSideLen = 0;
        int[][] dp = new int[rows+1][cols+1];
        
        for(int row=1; row<=rows; row++){
            for(int col=1; col<=cols; col++){
                if(matrix[row-1][col-1]=='1'){
                    dp[row][col] = Math.min(Math.min(dp[row-1][col], dp[row-1][col-1]), dp[row][col-1]) + 1;
                    maxSideLen = Math.max(maxSideLen, dp[row][col]);
                }
            }
        }
        
        return maxSideLen * maxSideLen;
    }
}