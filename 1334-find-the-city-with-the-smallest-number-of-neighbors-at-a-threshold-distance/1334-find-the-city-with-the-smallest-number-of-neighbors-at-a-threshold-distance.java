class Solution {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        int[][] grid = new int[n][n];
        for(int[] row : grid){
            Arrays.fill(row,-1);
        }
        for(int[] edge : edges){
            int x = edge[0];
            int y = edge[1];
            int w = edge[2];
            
            grid[x][y]=w;
            grid[y][x]=w;
        }
        
        int minCitiesReached = Integer.MAX_VALUE;
        int city = -1;
        
        for(int i=0; i<n; i++){
            int citiesReached = findReachableCities(i,grid,distanceThreshold);
            if(minCitiesReached >= citiesReached){
                minCitiesReached = citiesReached;
                city = i;
            }
            
        }
                                        
        return city;
    }
                                        
    public int findReachableCities(int node, int[][] grid, int distance){
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->a[1]-b[1]);
        int[] curr = {node,0};
        pq.add(curr);
        
        boolean[] visited = new boolean[grid.length];
        int reached = 0;
        
        while(!pq.isEmpty()){
            int[] element = pq.poll();
            int city = element[0];
            int dist = element[1];
            if(visited[city]){
                continue;
            }
            visited[city] = true;
            reached++;
            for(int col=0; col<grid[0].length;col++){
                if(grid[city][col] > -1 && !visited[col]){
                    int remDistance = dist + grid[city][col];
                    if(remDistance <= distance){
                        pq.add(new int[]{col,remDistance});
                    }
                }
            }
        }
        
        return reached;
    }
}