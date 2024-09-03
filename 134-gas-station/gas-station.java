class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int totalGain = 0;
        int currentGain = 0;
        int startIndex = 0;
        
        for(int i=0; i<gas.length; i++){
            totalGain += gas[i] - cost[i];
            currentGain += gas[i] - cost[i];
            
            if(currentGain < 0){
                startIndex = i+1;
                currentGain = 0;
            }
        }
        
        return totalGain >= 0?startIndex:-1;
    }
}