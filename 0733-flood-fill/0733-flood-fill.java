class Solution {
    int[][] directions = new int[][]{{1,0},{-1,0},{0,1},{0,-1}};
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int rows = image.length;
        int cols = image[0].length;
        
        boolean[][] visited = new boolean[rows][cols];
        
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{sr,sc});
        visited[sr][sc] = true;
        
        while(!q.isEmpty()){
            int[] curr = q.poll();
            
            for(int[] direction : directions){
                int nextRow = curr[0] + direction[0];
                int nextCol = curr[1] + direction[1];
                
                if(nextRow >=0 && nextRow < rows && nextCol >=0 && nextCol < cols && image[sr][sc]==image[nextRow][nextCol] && !visited[nextRow][nextCol]){
                    q.add(new int[]{nextRow,nextCol});
                    visited[nextRow][nextCol] = true;
                    image[nextRow][nextCol] = color;
                }
            }
        }
        
        image[sr][sc] = color;
        
        return image;
        
    }
}