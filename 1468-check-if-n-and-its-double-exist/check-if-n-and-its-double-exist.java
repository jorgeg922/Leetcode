class Solution {
    public boolean checkIfExist(int[] arr) {
        Set<Integer> seen = new HashSet<>();
        
        for(int j=0; j<arr.length; j++){
            if(seen.contains(arr[j]*2) || (arr[j]%2==0 && seen.contains(arr[j]/2))){
                return true;
            }
            seen.add(arr[j]);

        }
               
        return false;
    }
}