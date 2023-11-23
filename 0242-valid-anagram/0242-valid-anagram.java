class Solution {
    public boolean isAnagram(String s, String t) {
        HashMap<Character, Integer> frequency = new HashMap<>();
        for(char c : s.toCharArray()){
            frequency.put(c, frequency.getOrDefault(c,0)+1);
        }
        
        for(char c : t.toCharArray()){
            if(!frequency.containsKey(c)){
                return false;
            }
            
            frequency.put(c, frequency.get(c)-1);
            if(frequency.get(c) == 0){
                frequency.remove(c);
            }
        }
        
        if(frequency.isEmpty()){
            return true;
        }
        
        return false;
    }
}