class Solution {
    public int countComponents(int n, int[][] edges) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for(int[] edge : edges){
            int x = edge[0];
            int y = edge[1];
            
            if(!graph.containsKey(x)){
                graph.put(x, new ArrayList<>());
            }
            if(!graph.containsKey(y)){
                graph.put(y, new ArrayList<>());
            }
            
            graph.get(x).add(y); 
            graph.get(y).add(x);
        }
        
        Set<Integer> seen = new HashSet<>();
        int connectedComponents = 0;
        
        for(int i=0; i<n; i++){
            
            if(!graph.containsKey(i)){
                connectedComponents+=1;
                continue;
            }
            
            if(!seen.contains(i)){
                connectedComponents+=1;
                dfs(i, graph, seen);
            }
        }
        
        return connectedComponents;
    }
    
    
    public void dfs(int i, Map<Integer, List<Integer>> graph, Set<Integer> seen){
        if(seen.contains(i)){
            return;
        }
        
        seen.add(i);
        
        for(int edge : graph.get(i)){
            dfs(edge, graph, seen);
        }
    }
}