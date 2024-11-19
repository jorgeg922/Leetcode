class Solution {
    public int[][] merge(int[][] intervals) {
        Deque<int[]> q = new LinkedList<>();
        
        Arrays.sort(intervals, new Comparator<>(){
            public int compare(int[] a, int[] b){
                return a[0] - b[0];
            }
        });
        
        for(int[] interval : intervals){
            if(q.isEmpty()){
                q.addFirst(interval);
                continue;
            }
            
            int lastEntryStart = q.peekLast()[0];
            int lastEntryEnd = q.peekLast()[1];
            
            if(interval[0] > lastEntryEnd){
                q.addLast(interval);
            }else if(interval[1] > lastEntryEnd){
                q.getLast()[1] = interval[1];
            }
            
        }
        
        int[][] ans = new int[q.size()][2];
        int i = 0;
        
        while(!q.isEmpty()){
            ans[i] = q.pollFirst();
            i++;
        }
        
        return ans;
    }
}