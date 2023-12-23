class Solution {
    class Node{
        int prereqs;
        List<Integer> links = new LinkedList<>();
    }
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        HashMap<Integer,Node> graph = new HashMap<>();
        
        for(int[] entry : prerequisites){
            int prevCourse = entry[1];
            int course = entry[0];
            
            if(!graph.containsKey(prevCourse)){
                graph.put(prevCourse, new Node());
            }
            
            if(!graph.containsKey(course)){
                graph.put(course, new Node());
            }
            
            graph.get(course).prereqs += 1;
            graph.get(prevCourse).links.add(course);
        }
        
        LinkedList<Integer> noReqs = new LinkedList<>();
        for(Map.Entry<Integer,Node> entry : graph.entrySet()){
            if(entry.getValue().prereqs == 0){
                noReqs.add(entry.getKey());
            }
        }
        
        int removedEdges = 0;
        while(!noReqs.isEmpty()){
            int course = noReqs.pollFirst();
            for(int nextCourse : graph.get(course).links){
                Node nCourse = graph.get(nextCourse);
                nCourse.prereqs -= 1;
                removedEdges += 1;
                if(nCourse.prereqs == 0){
                    noReqs.add(nextCourse);
                }
            }
        }
        
        if(removedEdges != prerequisites.length){
            return false;
        }
        
        return true;
    }
}