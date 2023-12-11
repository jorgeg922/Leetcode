class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int rows = mat.length;
        int cols = mat[0].length;
        int[][] directions = new int[][]{{0,1},{0,-1},{1,0},{-1,0}};
        boolean[][] visited = new boolean[rows][cols];
        Queue<int[]> q = new LinkedList<>();
        
        for(int row=0; row<rows; row++){
            for(int col=0; col<cols; col++){
               if(mat[row][col] == 0){
                   q.add(new int[]{row,col});
                   visited[row][col] = true;
               } 
            }
        }
        
        int distance = 0;
        while(!q.isEmpty()){
            distance++;
            int size = q.size();
            for(int i=0; i<size; i++){
                int[] current = q.poll();
                for(int[] direction : directions){
                    int newRow = current[0] + direction[0];
                    int newCol = current[1] + direction[1];
                    
                    if(newRow >=0 && newRow<rows && newCol >=0 && newCol<cols && !visited[newRow][newCol]){
                        mat[newRow][newCol] = distance;
                        visited[newRow][newCol]=true;
                        q.add(new int[]{newRow,newCol});
                    }
                }
            }
        }
        
        return mat;
    }
}