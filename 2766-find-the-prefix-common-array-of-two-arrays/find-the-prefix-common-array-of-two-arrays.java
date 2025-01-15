class Solution {
    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        int n = A.length;
        int[] ans = new int[n];

        Set<Integer> seenA = new HashSet<>();
        Set<Integer> seenB = new HashSet<>();

        int prevCount = 0;
        for(int i=0; i<n; i++){
            int A_val = A[i];
            int B_val = B[i];

            seenA.add(A_val);
            seenB.add(B_val);

            int newCount = 0;
            if(A_val == B_val){
                newCount++;
            }else{
                if(seenB.contains(A_val)){
                    newCount++;
                }
                if(seenA.contains(B_val)){
                    newCount++;
                }
            }

            ans[i] = prevCount + newCount;
            prevCount = ans[i]; 
        }

        return ans;

    }
}