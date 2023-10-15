class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, new Comparator<int[]>(){
            public int compare(int[]a, int[]b){
                return a[0]-b[0];
            }
        });
        
        
        LinkedList<int[]> ll = new LinkedList<>();
        for(int[] curr : intervals){
            if(ll.isEmpty()){
                ll.addLast(curr);
                continue;
            }
            
            int[] last = ll.getLast();
            if(last[1] >= curr[0] && last[1] < curr[1]){
                last[1] = curr[1];
            }else if(last[1] < curr[0]){
                ll.addLast(curr);
            }
        }
        
        int[][] ans = new int[ll.size()][2];
        int i = 0;
        while(!ll.isEmpty()){
            int[] first = ll.pollFirst();
            ans[i]=first;
            i++;
        }
        
        return ans;
    }
}