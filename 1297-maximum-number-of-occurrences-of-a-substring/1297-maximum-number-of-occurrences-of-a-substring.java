class Solution {
    public int maxFreq(String s, int maxLetters, int minSize, int maxSize) {
        Map<String,Integer> occurrences = new HashMap<>();
        
        int[] countLetters = new int[26];
        
        int countUnique = 0;
        int left = 0;
        int right = 0;
        int maxOcurreneces = 0;
        
        while(right < s.length()){
            char r = s.charAt(right++);
            countLetters[r-'a']++;
            
            if(countLetters[r-'a'] == 1){
                countUnique++;
            }
            
            while((right-left) >= minSize && (right-left) <= maxSize){
                if(countUnique <= maxLetters){
                    String subs = s.substring(left,right);
                    occurrences.put(subs, occurrences.getOrDefault(subs,0)+1);
                    if(occurrences.get(subs) > maxOcurreneces){
                        maxOcurreneces = occurrences.get(subs);
                    }
                }
                
                char l = s.charAt(left++);
                countLetters[l-'a']--;
                
                if(countLetters[l-'a']==0){
                    countUnique--;
                }
            }
        }
        
        return maxOcurreneces;
    }
}