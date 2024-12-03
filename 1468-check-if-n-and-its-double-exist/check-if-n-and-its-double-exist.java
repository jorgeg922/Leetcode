class Solution {
    public boolean checkIfExist(int[] arr) {
        Set<Integer> seen = new HashSet<>();
        
        for(int j=0; j<arr.length; j++){
            if(seen.contains(arr[j]*2)){
                return true;
            }
            seen.add(arr[j]);

        }
        
        seen = new HashSet<>();
        
        for(int j=arr.length-1; j>=0; j--){
            if(seen.contains(arr[j]*2)){
                return true;
            }
            seen.add(arr[j]);

        }
        
        return false;
    }
}