class Solution {
    HashMap<String, List<String>> flightMap = new HashMap<>();
    HashMap<String, boolean[]> visitBitmap = new HashMap<>();
    int flights = 0;
    List<String> result = null;
    public List<String> findItinerary(List<List<String>> tickets) {
        for(List<String> ticket : tickets){
            String origin = ticket.get(0);
            String dest = ticket.get(1);
            
            if(this.flightMap.containsKey(origin)){
                List<String> destList = this.flightMap.get(origin);
                destList.add(dest);
            }else{
                List<String> destList = new LinkedList<String>();
                destList.add(dest);
                this.flightMap.put(origin,destList);
            }
        }
        
        for(Map.Entry<String,List<String>> entry : flightMap.entrySet()){
            Collections.sort(entry.getValue());
            this.visitBitmap.put(entry.getKey(),new boolean[entry.getValue().size()]);
            
        }
        
        this.flights = tickets.size();
        LinkedList<String> route = new LinkedList<String>();
        route.add("JFK");
        
        backtracking("JFK", route);
        return this.result;
    }
    
    public boolean backtracking(String origin, LinkedList<String> route){
        if(route.size() == flights + 1){
            result = (List<String>) route.clone();
            return true;
        }
        
        if(!this.flightMap.containsKey(origin)){
            return false;
        }
        
        int i=0;
        boolean[] bitmap = this.visitBitmap.get(origin);
        
        for(String dest : this.flightMap.get(origin)){
            if(!bitmap[i]){
                bitmap[i] = true;
                route.add(dest);
                boolean ret = backtracking(dest,route);
                route.pollLast();
                bitmap[i]=false;
                
                if(ret){
                    return true;
                }
            }
            i++;
        }
        
        return false;
    }
}