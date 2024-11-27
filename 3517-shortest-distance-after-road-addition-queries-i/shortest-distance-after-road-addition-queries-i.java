class Solution {
    public int[] shortestDistanceAfterQueries(int n, int[][] queries) {
        Map<Integer,List<Integer>> graph = new HashMap<>();
        
        for(int i=0; i<n-1; i++){
            graph.put(i, new ArrayList<>());
            graph.get(i).add(i+1);
        }
        
        int[] ans = new int[queries.length];
        int ptr = 0;
        int[] memo = new int[n];
        Arrays.fill(memo, Integer.MAX_VALUE);
        
        for(int[] query : queries){
            graph.get(query[0]).add(query[1]);
            for(int j=0; j<=query[0]; j++){
                memo[j]=Integer.MAX_VALUE;
            }
            ans[ptr++] = findShortestPath(0,n-1, graph, memo); 
        }
        
        return ans;
    }
    
    
    public int findShortestPath(int origin, int destination, Map<Integer,List<Integer>> graph, int[] memo){
        if(origin == destination){
            return 0;
        }
        
        if(memo[origin] != Integer.MAX_VALUE){
            return memo[origin];
        }
        
        int pathLen = Integer.MAX_VALUE;
        
        for(int neighbor : graph.get(origin)){
            pathLen = Math.min(pathLen, findShortestPath(neighbor,destination,graph, memo)+1);
        }
        
        memo[origin] = pathLen;
        return pathLen;
    }
}