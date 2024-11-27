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
        
        for(int i=0; i<n; i++){
            if(graph.containsKey(i)){
               removeWeakerTeams(i, graph);
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