class Solution {
    public int findChampion(int n, int[][] edges) {
        
        Map<Integer, List<Integer>> graph = new HashMap<>();
        
        for(int i=0; i<n; i++){
            graph.put(i, new ArrayList<>());
        }
        
        for(int[] edge : edges){
            int team1 = edge[0];
            int team2 = edge[1];
            
            graph.get(team1).add(team2);
        }
        
        if(graph.size() == 1){
           for(int team : graph.keySet()){
                return team;
            } 
        }
        
        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<>(){
            public int compare(Integer a, Integer b){
                if(graph.get(a) == null){
                    return b;
                }
                if(graph.get(b) == null){
                    return a;
                }
                return graph.get(b).size() - graph.get(a).size();
            }
        });
        
        for(int team : graph.keySet()){
            if(graph.get(team) == null){
                continue;
            }
            pq.add(team);
        }
        
        while(!pq.isEmpty()){
                int currentTeam = pq.poll();
            if(graph.containsKey(currentTeam)){
               removeWeakerTeams(currentTeam, graph);
            }   
        }
        
        if(graph.size() == 1){
           for(int team : graph.keySet()){
                return team;
            } 
        }
        
        return -1;
    }
    
    public void removeWeakerTeams(int team, Map<Integer,List<Integer>> graph){
        if(graph.get(team) == null){
            return;
        }
        
        List<Integer> weakerTeams = graph.get(team);
        
        for(int weakerTeam : weakerTeams){
            removeWeakerTeams(weakerTeam, graph);
            graph.remove(weakerTeam);
        }
    }
}