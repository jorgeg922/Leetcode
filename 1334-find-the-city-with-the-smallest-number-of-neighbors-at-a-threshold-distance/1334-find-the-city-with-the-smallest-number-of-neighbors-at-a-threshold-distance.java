class Solution {
    int distanceThreshold;
    int N;
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        this.distanceThreshold = distanceThreshold;
        this.N = n;
        int[][] graph = new int[n][n];
        for(int[] row : graph){
            Arrays.fill(row,-1);
        }
        for(int[] edge : edges){
            int x = edge[0];
            int y = edge[1];
            int w = edge[2];
            
            graph[x][y]=w;
            graph[y][x]=w;
        }
        
        int city = -1;
        int minReachable = Integer.MAX_VALUE;
        for(int i=0; i<n; i++){
            int citiesReached = dfs(i,graph);
            if(minReachable >= citiesReached){
                minReachable = citiesReached;
                city = i;
            }
        }
        
        return city;
    }
    
    public int dfs(int city, int[][] graph){
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<>(){
            public int compare(int[] a, int[] b){
                return a[1]-b[1];
            }
        });
        
        Set<Integer> visited = new HashSet<>();
        pq.add(new int[]{city,0});
        int citiesReached = 0;
        
        while(!pq.isEmpty()){          
            int[] edge = pq.poll();
            int newcity = edge[0];            
            int dist = edge[1];
            
            if(visited.contains(newcity)){
                continue;
            }
            
            citiesReached++;
            visited.add(newcity);
            for(int col=0; col<N; col++){
                if(graph[newcity][col] != -1 && !visited.contains(col)){
                    int distanceTraveled =  dist+graph[newcity][col];
                    if(distanceTraveled <= distanceThreshold){
                         pq.add(new int[]{col,dist+graph[newcity][col]});
                    }                   
                }
            }
        }
        
        return citiesReached;
        
    }
}