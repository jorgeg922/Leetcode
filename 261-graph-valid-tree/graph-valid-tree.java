class Solution {
    public boolean validTree(int n, int[][] edges) {
        if(n == 1 && edges.length==0){
            return true;
        }
        
        HashMap<Integer,List<Integer>> graph = new HashMap<>();
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
        
        Queue<Integer> q = new LinkedList<>();
        Set<Integer> inQueue = new HashSet<>();
        Set<Integer> seen = new HashSet<>();
        
        for(int i=0; i<n; i++){
            if(!graph.containsKey(i)){
                return false;
            }
        }
        
        q.add(0);
        inQueue.add(0);
        
        while(!q.isEmpty()){
            int size = q.size();
            for(int i=0; i<size; i++){
                int curr = q.poll();
                inQueue.remove(curr);
                seen.add(curr);
                for(int link : graph.get(curr)){
                    if(!seen.contains(link)){
                        if(inQueue.contains(link)){
                            return false;
                        }
                        q.add(link);
                        inQueue.add(link);
                    }
                }
            }
        }
        
        if(seen.size() != n){
            return false;
        }
        
        return true;
    }
}