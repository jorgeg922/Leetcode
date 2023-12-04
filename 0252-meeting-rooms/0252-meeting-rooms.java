class Solution {
    public boolean canAttendMeetings(int[][] intervals) {
        if(intervals.length == 1){
            return true;
        }
        
        Arrays.sort(intervals,(a,b) -> a[0]-b[0]);
        
        for(int i=1; i<intervals.length; i++){
            int start = intervals[i][0];           
            int prevEnd = intervals[i-1][1];
            
            if(start < prevEnd){
                return false;
            }
        }
        
        return true;
        
    }
}