class Solution {
    public int garbageCollection(String[] garbage, int[] travel) {
        int paperTruckLocation =0;
        //int paperTruckTravelTime = 0;
        int metalTruckLocation =0;
        //int metalTruckTravelTime =0;
        int glassTruckLocation =0;
        //int glassTruckTravelTime =0;
        int totalTravelTime = 0;
        int[] travelTimes = new int[garbage.length];
        travelTimes[0] = 0;
        for(int i =1; i<garbage.length; i++){
            travelTimes[i] = travelTimes[i-1] + travel[i-1];
        }
        
        for(int i=0; i<garbage.length; i++){
            char[] bins = garbage[i].toCharArray();
            
            for(char trashType : bins){
                switch(trashType){
                    case 'G':
                        totalTravelTime += travelTimes[i] - travelTimes[glassTruckLocation] + 1;
                        glassTruckLocation = i;
                        break;
                    case 'P':
                        totalTravelTime += travelTimes[i] - travelTimes[paperTruckLocation] + 1;
                        paperTruckLocation = i;
                        break;
                    case 'M':
                        totalTravelTime += travelTimes[i] - travelTimes[metalTruckLocation] + 1;
                        metalTruckLocation = i;
                        break;
                }
            }
        }
        return totalTravelTime;
    }
}