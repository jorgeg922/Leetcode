class Solution {
    public int getFood(char[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        
        for(int row=0; row<rows; row++){
            for(int col=0; col<cols; col++){
                if(grid[row][col] == '*'){
                    return bfs(row,col,grid);
                }
            }
        }
        
        return -1;
    }
    
    public int bfs(int row, int col, char[][] grid){
        Queue<int[]> q = new LinkedList<>();
        boolean[][] seen = new boolean[grid.length][grid[0].length];
        int[][] directions = new int[][]{{1,0},{-1,0},{0,1},{0,-1}};
        q.add(new int[]{row,col});
        seen[row][col] = true;
        
        
        int steps = 0;
        while(!q.isEmpty()){
            int size = q.size();
            for(int i=0; i<size; i++){
                int[] currentLocation = q.poll();
                if(grid[currentLocation[0]][currentLocation[1]] == '#'){
                    return steps;
                }
                
                for(int[] direction : directions){
                    int nextRow = currentLocation[0] + direction[0];
                    int nextCol = currentLocation[1] + direction[1];
                    if(nextRow<0 || nextRow>=grid.length || nextCol<0 || nextCol >= grid[0].length || grid[nextRow][nextCol] == 'X' || seen[nextRow][nextCol]){
                        continue;
                    }
                    q.add(new int[]{nextRow,nextCol});
                    seen[nextRow][nextCol] = true;
                }
            }
            steps++;
        }
        
        return -1;
    }
}