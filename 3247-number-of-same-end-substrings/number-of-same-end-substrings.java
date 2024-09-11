class Solution {
    public int[] sameEndSubstringCount(String s, int[][] queries) {
        int[][] prefixSums = new int[26][s.length()+1];
        
        for(int i=0; i<26; i++){
            for(int j=0; j<s.length(); j++){
                char c = s.charAt(j);
                if('a' + i == c){                    
                    prefixSums[i][j+1] = prefixSums[i][j]+1;                                  
                }else{                   
                    prefixSums[i][j+1] = prefixSums[i][j];  
                    
                }
            }
        }
        
        int[] ans = new int[queries.length];
        int ptr = 0;
        for(int[] query : queries){
            int start = query[0];
            int end = query[1];
            for(int i=0; i<26; i++){
              int diff = prefixSums[i][end+1] - prefixSums[i][start];
              ans[ptr] += (diff*(diff+1))/2;  
            }
            ptr++;
        }
        
        return ans;
    }
}