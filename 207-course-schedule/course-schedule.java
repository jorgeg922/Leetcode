class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, Set<Integer>> courseMap = new HashMap<>();
        
        for(int i=0; i<numCourses; i++){
            courseMap.put(i, new HashSet<>());
        }
        
        for(int[] courseReq : prerequisites){
            int course = courseReq[0];
            int req = courseReq[1];
            
            courseMap.get(course).add(req);
        }
        
        Queue<Integer> q = new LinkedList<>();
        
        for(Map.Entry<Integer,Set<Integer>> entry : courseMap.entrySet()){
            if(entry.getValue().size() == 0){
                q.add(entry.getKey());
            }    
        }
        
        if(q.isEmpty()){
            return false;
        }
        
        int coursesTaken = 0;
        
        while(!q.isEmpty()){
            int currCourse = q.poll();
            coursesTaken++;
            for(Map.Entry<Integer,Set<Integer>> entry : courseMap.entrySet()){
                Set<Integer> currReqs = entry.getValue(); 
                if(currReqs.contains(currCourse)){
                    currReqs.remove(currCourse);
                    
                    if(currReqs.size() == 0){
                        q.add(entry.getKey());
                    }
                }  
            }
        }
        
        return coursesTaken==numCourses?true:false;
    }
}