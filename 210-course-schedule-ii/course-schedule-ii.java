class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> prereqs = new HashMap<>();
        Map<Integer, Integer> numOfPrereqs = new HashMap<>();
        
        for(int i=0; i<numCourses; i++){
            prereqs.put(i, new ArrayList<>());
            numOfPrereqs.put(i,0);
        }
        
        for(int[] prerequisite : prerequisites){
            int requirement = prerequisite[1];
            int course = prerequisite[0];
            
            prereqs.get(requirement).add(course);
            numOfPrereqs.put(course, numOfPrereqs.getOrDefault(course,0)+1);
        }
        
        Queue<Integer> q = new LinkedList<>();
        for(Map.Entry<Integer,Integer> entry : numOfPrereqs.entrySet()){
            if(entry.getValue() == 0){
                q.add(entry.getKey());
            }
        }
        
        List<Integer> ans = new ArrayList<>();
        while(!q.isEmpty()){
            int currCourse = q.poll();
            ans.add(currCourse);
            List<Integer> canTakeAfter = prereqs.get(currCourse);
            for(int canTake : canTakeAfter){
                if(numOfPrereqs.get(canTake) > 0){
                    numOfPrereqs.put(canTake, numOfPrereqs.get(canTake)-1);
                }
                if(numOfPrereqs.get(canTake) <= 0){
                    q.add(canTake);
                }
            }
        }
        

        return ans.size()==numCourses?ans.stream().mapToInt(i->i).toArray():new int[]{};
    }
}