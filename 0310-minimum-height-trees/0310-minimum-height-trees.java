class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if(edges.length == 0){           
            return Arrays.asList(0);
        }
        if(n < 2){
             return Arrays.asList(0,1);
        }
        
        HashMap<Integer,Set<Integer>> graph = new HashMap<>();
        
        for(int[] edge : edges){
            int a = edge[0];
            int b = edge[1];
            
            if(!graph.containsKey(a)){
                graph.put(a, new HashSet<>());
            }
            
            if(!graph.containsKey(b)){
                graph.put(b, new HashSet<>());
            }
            
            graph.get(a).add(b);
            graph.get(b).add(a);
        }
        
        Queue<Integer> leafs = new LinkedList<>();
        for(Map.Entry<Integer,Set<Integer>> entry : graph.entrySet()){
            if(entry.getValue().size() == 1){
                leafs.add(entry.getKey());
            }
        }
        
        int remainingNodes = n;
        while(remainingNodes > 2){
            int size = leafs.size();
            remainingNodes -= size;
            for(int i=0; i<size; i++){
                int currentLeaf = leafs.poll();
                int neighbor = graph.get(currentLeaf).iterator().next();
                graph.get(neighbor).remove(currentLeaf);
                if(graph.get(neighbor).size() == 1){
                    leafs.add(neighbor);
                }
            }
        }
        
        List<Integer> ans = new ArrayList<>(leafs);
        
        return ans;
    }
}