class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        List<Integer> ans = new ArrayList<>();
        int[] state = new int[graph.length];// 0=unvisited, 1=visiting, 2=safe

        for(int i=0; i<graph.length; i++){
            if(isItSafe(i, graph, state)){
                ans.add(i);           
            }
        }

        return ans;
    }

    public boolean isItSafe(int node, int[][] graph, int[] state){
        if(state[node] == 1){
            return false;
        }

        if(state[node] == 2){
            return true;
        }

        state[node] = 1;

        for(int neighbor : graph[node]){
            
            if(!isItSafe(neighbor, graph, state)){
                return false;
            }

        }

        state[node] = 2;
        return true;
    }
}