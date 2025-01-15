class Solution {
    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        int n = A.length;
        int[] ans = new int[n];

        Map<Integer,Integer> seenA = new HashMap<>();
        Map<Integer, Integer> seenB = new HashMap<>();

        int prevCount = 0;
        for(int i=0; i<n; i++){
            int A_val = A[i];
            int B_val = B[i];

            seenA.put(A_val, 1);
            seenB.put(B_val, 1);

            int newCount = 0;
            if(A_val == B_val){
                newCount++;
            }else{
                if(seenB.containsKey(A_val)){
                    newCount++;
                }
                if(seenA.containsKey(B_val)){
                    newCount++;
                }
            }

            ans[i] = prevCount + newCount;
            prevCount = ans[i]; 
        }

        return ans;

    }
}