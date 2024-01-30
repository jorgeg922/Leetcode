class Solution {
   class Node{
       int prereqs=0;
       List<Integer> links = new LinkedList<>();
   }
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        HashMap<Integer, Node> graph = new HashMap<>();
        for(int i=0; i<numCourses; i++){
            graph.put(i, new Node());
        }
        
        for(int[] courses : prerequisites){
            int prev = courses[1];
            int curr = courses[0];
            
            if(!graph.containsKey(prev)){
                graph.put(prev, new Node());
            }
            if(!graph.containsKey(curr)){
                graph.put(curr, new Node());
            }
            
            graph.get(curr).prereqs += 1;
            graph.get(prev).links.add(curr);
        }
        
        
        Queue<Integer> q = new LinkedList<>();
        List<Integer> order = new ArrayList<>();
        
        for(Map.Entry<Integer,Node> entry : graph.entrySet()){
            if(entry.getValue().prereqs == 0){
                q.add(entry.getKey());
            }
        }
        
        
        while(!q.isEmpty()){
            int currCourse = q.poll();
            order.add(currCourse);
            for(int nextCourse : graph.get(currCourse).links){
                Node next = graph.get(nextCourse);
                next.prereqs-=1;
                if(next.prereqs == 0){
                    q.add(nextCourse);
                }
            }
        }
        
        if(order.size() != numCourses){
            return new int[]{};
        }
        
        return order.stream().mapToInt(i->i).toArray();
    }
    
}