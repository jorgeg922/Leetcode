class Solution {
    public int minKnightMoves(int x, int y) {
        int[][] directions = new int[][] {{2,1},{2,-1},{-2,1},{-2,-1},{1,2},{1,-2},{-1,2},{-1,-2}};     
        
        Queue<int[]> q = new LinkedList<>();
        boolean[][] seen = new boolean[601][601];
        
        q.add(new int[]{0,0});
        seen[0][0] = true;
        int moves = 0;
        
        while(!q.isEmpty()){
            int size = q.size();
            for(int i=0; i<size; i++){
                int[] position = q.poll();
                int xPos = position[0];
                int yPos = position[1];
                if(xPos == x && yPos==y){
                    return moves;
                }
                for(int[] direction : directions){
                    int nextX = xPos + direction[0];
                    int nextY = yPos + direction[1];
                    if(nextX > 300 || nextX < -300 || nextY < -300 || nextY > 300 || seen[nextX + 300][nextY + 300]){
                        continue;
                    }                   
                    seen[nextX + 300][nextY + 300] = true;
                    q.add(new int[]{nextX,nextY});
                }
            }
            moves++;
        }
        return -1;
    }
}