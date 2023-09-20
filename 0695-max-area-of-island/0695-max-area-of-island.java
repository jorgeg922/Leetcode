class Solution {
    int[][] neighbors = new int[][]{{0,1},{0,-1},{1,0},{-1,0}};
    public int maxAreaOfIsland(int[][] grid) {
        int maxArea = Integer.MIN_VALUE;
        int rows = grid.length;
        int cols = grid[0].length;
        boolean[][] visited = new boolean[rows][cols];

        for(int row=0; row<rows; row++){
            for(int col=0; col<cols; col++){
                if(grid[row][col] == 1 && !visited[row][col]){
                    maxArea = Math.max(maxArea, bfs(row,col,grid,visited));
                }
            }
        }
        
        return maxArea == Integer.MIN_VALUE ? 0 : maxArea;
    }
    
    public int bfs(int row, int col, int[][] grid, boolean[][] visited){
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{row,col});
        visited[row][col] = true;
        
        int area = 0;
        while(!q.isEmpty()){
            int[] cell = q.poll();
            area += 1;
            for(int[] neighbor : neighbors){
                int nextRow = cell[0] + neighbor[0];
                int nextCol = cell[1] + neighbor[1];
                if(validCell(nextRow,nextCol,grid) && !visited[nextRow][nextCol]){
                    q.add(new int[]{nextRow,nextCol});
                    visited[nextRow][nextCol] = true;
                }
            }
        }
        
        return area;
        
        
    }
    
    public boolean validCell(int row, int col, int[][] grid){
       if(row < 0 || row >= grid.length || col < 0 || col >= grid[0].length || grid[row][col] == 0){
            return false;
        } 
        
        return true;
    }
}