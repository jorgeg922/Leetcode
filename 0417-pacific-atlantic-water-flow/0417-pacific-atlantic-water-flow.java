class Solution {
    int n;
    int m;
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        
        n = heights.length;
        m = heights[0].length;
        
        boolean[][] pacificReachable = new boolean[n][m];
        boolean[][] atlanticReachable = new boolean[n][m];
        
        for(int row = 0; row<n; row++){
            check(row,0,pacificReachable,heights);
            check(row,m-1,atlanticReachable,heights);
        }
        
        for(int col=0; col<m; col++){
            check(0,col,pacificReachable,heights);
            check(n-1,col,atlanticReachable,heights);
        }
        
        List<List<Integer>> reachesBoth = new ArrayList<>();
        
        for(int row=0; row<n; row++){
            for(int col=0; col<m; col++){
                if(pacificReachable[row][col] && atlanticReachable[row][col]){
                    reachesBoth.add(List.of(row,col));
                }        
            }
        }
        
        return reachesBoth;
    }
    
    
    public void check(int row, int col, boolean[][] reachable, int[][] heights){
        
        reachable[row][col] = true;
        
        int[] x = {-1,0,1,0};
        int[] y = {0,-1,0,1};
        
        for(int i=0; i<4; i++){
            int nextRow = row + x[i];
            int nextCol = col + y[i];
            
            if(nextRow < 0 || nextRow >= n || nextCol < 0 || nextCol >= m || reachable[nextRow][nextCol]){
                continue;
            }
            
            if(heights[nextRow][nextCol] >= heights[row][col]){
                check(nextRow,nextCol,reachable,heights);
            }
        }
    }
}