class Solution {
    public int numSquares(int n) {
        int[] dp = new int[n+1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        int max_square = (int) Math.sqrt(n) + 1;
        int[] squares = new int[max_square];
        
        for(int i=0; i<max_square; i++){
            squares[i] = i*i;
        }
        
        dp[0]=0;
        
        for(int i=1; i<=n; i++){
            for(int square=1; square<max_square; square++){
                if(i < squares[square]){
                    break;
                }
                dp[i] = Math.min(dp[i], dp[i-squares[square]]+1);
            }
        }
        return dp[n];
    }
}