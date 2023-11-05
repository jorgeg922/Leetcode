class Solution {
    int[][] neighbors = new int[][]{{1,0},{-1,0},{0,1},{0,-1}};
    public int minimumTime(int[][] grid) {
        if(grid[0][1] > 1 && grid[1][0] > 1){
            return -1;
        }
        
        int rows = grid.length;
        int cols = grid[0].length;
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[2] - b[2]);
        pq.add(new int[]{0,0,0});
        
        boolean[][] visited = new boolean[rows][cols];
        
        while(!pq.isEmpty()){
            int[] current = pq.poll();
            int row = current[0];
            int col = current[1];
            int time = current[2];
            
            if(row == rows-1 && col == cols-1){
                return time;
            }
            
            if(visited[row][col]){
                continue;
            }
            visited[row][col] = true;
            
            for(int[] neighbor : neighbors){
                int newRow = row + neighbor[0];
                int newCol = col + neighbor[1];
                
                if(newRow < 0 || newRow >= rows || newCol < 0 || newCol >= cols || visited[newRow][newCol]){
                    continue;
                }
                
                if(grid[newRow][newCol] <= time + 1){
                    pq.add(new int[]{newRow,newCol,time+1});
                }else{
                    int diff = grid[newRow][newCol] - time;
                    if(diff % 2 == 1){
                        pq.add(new int[]{newRow,newCol,grid[newRow][newCol]});
                    }else{
                        pq.add(new int[]{newRow,newCol,grid[newRow][newCol]+1});
                    }
                }
                
            }
        }
        
        return -1;
    }
}