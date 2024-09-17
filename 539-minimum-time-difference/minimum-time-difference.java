class Solution {
    public int findMinDifference(List<String> timePoints) {
        List<Integer> timePts = new ArrayList<>();
        
        for(String timePoint : timePoints){
            String[] digits = timePoint.split(":");
            int mins = Integer.parseInt(digits[0])*60+Integer.parseInt(digits[1]);
            timePts.add(mins);
        }
        
        Collections.sort(timePts);
        
        int min = Integer.MAX_VALUE;
        for(int i=1; i<timePts.size(); i++){
            min = Math.min(min, getDifference(timePts.get(i-1), timePts.get(i)));
        }
        min = Math.min(min, getDifference(timePts.get(0), timePts.get(timePts.size()-1)));
        return min;
    }
    
    public int getDifference(int a, int b){
        int totalMins = 1440 + 60;
        
        int wayone = Math.abs(b-a);
        int waytwo = Math.abs(a+totalMins-b)-60;
            
        return Math.min(wayone, waytwo);
    }
}