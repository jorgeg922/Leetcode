class Solution {
    int[][] directions = new int[][]{{1,0},{-1,0},{0,1},{0,-1}};
    public int orangesRotting(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        
        Queue<int[]> q = new LinkedList<>();
        boolean[][] visited = new boolean[rows][cols];
        int oranges = 0;
        int fresh = 0;
        
        for(int row=0; row<rows; row++){
            for(int col=0; col<cols; col++){               
                if(grid[row][col] == 1){
                    oranges++;
                    fresh++;
                }else if(grid[row][col] == 2){
                    oranges++;
                    q.add(new int[]{row,col});                   
                    visited[row][col] = true;
                }
            }
        }
        
        if(fresh == 0){
            return 0;
        }
        
        int mins = 0;
        while(!q.isEmpty()){
            int size = q.size();           
            for(int i=0; i<size; i++){
                int[] curr = q.poll();
                visited[curr[0]][curr[1]] = true;
                for(int[] direction : directions){
                    int nextRow = curr[0] + direction[0];
                    int nextCol = curr[1] + direction[1];
                    
                    if(nextRow < 0 || nextRow >= rows || nextCol < 0 || nextCol >= cols || grid[nextRow][nextCol] == 0 || visited[nextRow][nextCol]){
                        continue;
                    }
                    
                    fresh--;
                    q.add(new int[]{nextRow,nextCol});
                    visited[nextRow][nextCol] = true;                   
                }
            }                        
              mins++;              
        }
        
        return fresh <= 0 ? mins-1 : -1;
    }
}