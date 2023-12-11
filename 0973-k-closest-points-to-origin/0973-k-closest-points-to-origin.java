class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<>(){
            public int compare(int[] a, int[] b){
                return ((a[0]*a[0]) + (a[1]*a[1])) - ((b[0]*b[0]) + (b[1]*b[1]));
            }
        });
        
        
        for(int[] point : points){
            pq.add(point);
        }
        
        int[][] ans = new int[k][2];
        
        for(int entry=0; entry<k; entry++){
            ans[entry] = pq.poll();
        }
        
        return ans;
        
    }
}