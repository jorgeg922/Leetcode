class Solution {
    public List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries) {
        List<Boolean> ans = new ArrayList<Boolean>();
        Map<Integer, List<Integer>> pr = new HashMap<>();

        for(int i=0; i<numCourses; i++){
            pr.put(i, new ArrayList<>());
        }

        for(int[] prereq : prerequisites){

            int next = prereq[1];
            int prev = prereq[0];           

            pr.get(next).add(prev);
        }

        for(int[] query: queries){
            int course = query[0];
            int targetCourse = query[1];

            Queue<Integer> q = new LinkedList<>();
            q.add(targetCourse);
            Set<Integer> visited = new HashSet<>();
            visited.add(targetCourse);

            boolean isItPrereq = false;
            while(!q.isEmpty()){
                List<Integer> prereqs = pr.get(q.poll());
                

                if(prereqs.contains(course)){
                    isItPrereq = true;
                    break;
                }

                for(int prereq : prereqs){
                    if(!visited.contains(prereq)){
                        q.add(prereq);
                        visited.add(prereq);
                    }
                }
               
            }

            ans.add(isItPrereq);
        }

        return ans;
    }
}