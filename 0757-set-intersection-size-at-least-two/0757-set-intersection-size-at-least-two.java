class Solution {
    public int intersectionSizeTwo(int[][] intervals) {
        Arrays.sort(intervals, new Comparator<>(){
            public int compare(int[] a, int[] b){
                if(a[1] == b[1]){
                    return a[0] - b[0];
                }
                
                return a[1] - b[1];
            }
        });
        
        List<Integer> ans = new ArrayList<>();
        ans.add(intervals[0][1]-1);
        ans.add(intervals[0][1]);
        
        for(int i=1; i<intervals.length; i++){
            int start = intervals[i][0];
            int end = intervals[i][1];
            int lastInserted = ans.get(ans.size()-1);
            int secondLastInserted = ans.get(ans.size()-2);
            
            if(start > lastInserted){
                ans.add(end-1);
                ans.add(end);
            }else if(start == lastInserted){
                ans.add(end);
            }else if(start > secondLastInserted){
                ans.add(end);
            }
            //else it overlaps with last entry. No need to add anything
        }
        
        return ans.size();        
    }
}