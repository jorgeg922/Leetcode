class Solution {
    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        int n = A.length;
        int[] ans = new int[n];

        Set<Integer> seen = new HashSet<>();
        //Set<Integer> seenB = new HashSet<>();

        int prevCount = 0;
        for(int i=0; i<n; i++){
            int A_val = A[i];
            int B_val = B[i];

            

            int newCount = 0;
            if(A_val == B_val){
                newCount++;
            }else{
                if(seen.contains(A_val)){
                    newCount++;
                }
                if(seen.contains(B_val)){
                    newCount++;
                }
            }
            seen.add(A_val);
            seen.add(B_val);
            ans[i] = prevCount + newCount;
            prevCount = ans[i]; 
        }

        return ans;

    }
}