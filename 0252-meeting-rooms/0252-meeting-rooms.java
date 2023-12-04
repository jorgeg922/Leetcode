class Solution {
    public boolean canAttendMeetings(int[][] intervals) {
        if(intervals.length == 1){
            return true;
        }
        
        Arrays.sort(intervals, new Comparator<>(){
            public int compare(int[] a, int[] b){
                if(a[0] == b[0]){
                    return a[1]-b[1];         
                }
                
                return a[0] - b[0];
            }
        });
        
        for(int i=1; i<intervals.length; i++){
            int start = intervals[i][0];
            int end = intervals[i][1];
            
            int prevStart = intervals[i-1][0];
            int prevEnd = intervals[i-1][1];
            
            if(start < prevEnd){
                return false;
            }
        }
        
        return true;
        
    }
}