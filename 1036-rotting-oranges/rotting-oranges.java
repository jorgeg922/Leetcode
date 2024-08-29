class Solution {
    int[][] directions = new int[][]{{1,0},{-1,0},{0,1},{0,-1}};
    public int orangesRotting(int[][] grid) {
        int rows=grid.length;
        int cols=grid[0].length;
        
        Queue<int[]> q = new LinkedList<>();
        boolean[][] visited = new boolean[rows][cols];
        int freshOranges = 0;
        
        for(int row=0; row<rows; row++){
            for(int col=0; col<cols; col++){
                if(grid[row][col] == 1){
                    freshOranges++;
                }
                if(grid[row][col] == 2){
                    q.add(new int[]{row,col});
                    visited[row][col]=true;
                }
            }
        }
        
        
        if(freshOranges == 0){
            return 0;
        }
        
        int minutes = 0;
        while(!q.isEmpty()){
            minutes++;
            int size = q.size();
            
            for(int i=0; i<size; i++){
                int[] curr = q.poll();
                int row = curr[0];
                int col = curr[1];
                
                for(int[] direction : directions){
                    int nextRow = row + direction[0];
                    int nextCol = col + direction[1];
                    
                    if(nextRow < 0 || nextRow >= rows || nextCol < 0 || nextCol >= cols || visited[nextRow][nextCol] || grid[nextRow][nextCol]==0){
                        continue;
                    }
                    
                    q.add(new int[]{nextRow, nextCol});
                    visited[nextRow][nextCol]=true;
                    freshOranges--;
                }
            }
             
        }
        
        return freshOranges==0?minutes-1:-1;
    }
}