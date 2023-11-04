class Solution {
    public List<String> buildArray(int[] target, int n) {
        List<String> operations = new ArrayList<>();
        int i=0;
        
        for(int num : target){
            while(i < num-1){
                operations.add("Push");
                operations.add("Pop");
                i++;
            }
            operations.add("Push");
            i++;
        }
        
        return operations;
    }
}