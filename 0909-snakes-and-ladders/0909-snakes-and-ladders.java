class Solution {
    public int snakesAndLadders(int[][] board) {
        int n = board.length;
       //
        HashMap<Integer,int[]> map = new HashMap<>();
        Integer[] columns = new Integer[n];
        int label = 1;
        
        for(int i=0; i<n; i++){
            columns[i] = i;
        }
        
        for(int row=n-1; row >=0; row--){
            for(int col : columns){
                map.put(label, new int[]{row,col});
                label++;
            }
            Collections.reverse(Arrays.asList(columns));
        }
        
        Queue<Integer> q = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();
        visited.add(1);
        q.add(1);
        int moves = 0;
        while(!q.isEmpty()){
            int size = q.size();
            for(int i=0; i<size; i++){
                int current = q.poll();
                if(current == n*n){
                    return moves;
                }
                for(int neighbor=current+1; neighbor<=Math.min(current+6, n*n); neighbor++){
                    int[] neighborCoordinates = map.get(neighbor);
                    int nrow = neighborCoordinates[0];
                    int ncol = neighborCoordinates[1];
                    int destination = -1;
                    if(board[nrow][ncol] != -1){
                           if (!visited.contains(board[nrow][ncol])) {
                              destination = board[nrow][ncol]; 
                              
                           }                     
                    }else if(!visited.contains(neighbor)) {
                              destination = neighbor; 
                    }
                                              
                    if(destination != -1){
                        q.add(destination);
                        visited.add(destination);
                    }
                    /*int dest = board[nrow][ncol] == -1 ? neighbor : board[nrow][ncol];

                    if (!visited.contains(dest)) {
                        q.add(dest);
                        visited.add(dest); // Mark this position as visited
                    }*/
                   
                }
               
            }
            moves++;
        }
        return -1;
    }
}


