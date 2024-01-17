class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int currentGain = 0;
        int totalGain = 0;
        int ans = 0;
        
        for(int i=0; i<gas.length; i++){
            currentGain += gas[i]-cost[i];
            totalGain += gas[i]-cost[i];
            
            if(currentGain < 0){
                ans = i+1;
                currentGain =0;
            }
        }
        
        return totalGain >= 0 ? ans : -1;
    }
}