class Solution {
    public char findTheDifference(String s, String t) {
        HashMap<Character, Integer> sfreq = new HashMap<>();
        HashMap<Character, Integer> tfreq = new HashMap<>();
        
        for(char c : s.toCharArray()){
            sfreq.put(c, sfreq.getOrDefault(c,0)+1);
        }
        
        for(char c : t.toCharArray()){
            if(!sfreq.containsKey(c)){
                return c;
            }
            
            tfreq.put(c, tfreq.getOrDefault(c,0)+1);
        }
        
        for(Map.Entry<Character,Integer> entry : tfreq.entrySet()){
            char current = entry.getKey();
            if(entry.getValue() != sfreq.get(current)){
               return current;
            }
        }
        
        return '0';
    }
}