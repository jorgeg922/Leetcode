class Solution {
    public int maxFreq(String s, int maxLetters, int minSize, int maxSize) {
        HashMap<String,Integer> occurrences = new HashMap<>();
        int[] map = new int[26];
        int left = 0;
        int right= 0;
        int uniques = 0;
        int maxOccurences = 0;
        
        while(right < s.length()){
            char c = s.charAt(right);
            map[c-'a']++;
            if(map[c-'a'] == 1){
                uniques++;
            }
            
            int len = right-left+1;
            if(len >= minSize && len <= maxSize){
                if(uniques <= maxLetters){
                    String sub = s.substring(left,right+1);
                    occurrences.put(sub, occurrences.getOrDefault(sub,0)+1);
                    if(occurrences.get(sub) > maxOccurences){
                        maxOccurences = occurrences.get(sub);
                    }
                }
                
                map[s.charAt(left)-'a']--;
        
                if(map[s.charAt(left)-'a']==0){
                    uniques--;
                }
                
                left++;
            }
            right++;
        }
        
        return maxOccurences;
    }
}