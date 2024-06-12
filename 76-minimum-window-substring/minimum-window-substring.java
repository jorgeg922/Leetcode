class Solution {
    public String minWindow(String s, String t) {
        
        if(t.length() > s.length()){
            return "";
        }
        
        Map<Character, Integer> frequency = new HashMap<>();
        for(char c : t.toCharArray()){
           frequency.put(c, frequency.getOrDefault(c,0)+1);
        }
        int minWindow = Integer.MAX_VALUE;
        String minWindowValue = "";
        int frequencySize = frequency.size();
        
        int left = 0;
        while(left < s.length() && !frequency.containsKey(s.charAt(left))){
            left++;
        }
              
        for(int right=left; right<s.length(); right++){
            char current = s.charAt(right);
            if(frequency.containsKey(current)){
                frequency.put(current, frequency.get(current)-1);
                if(frequency.get(current) == 0){
                    frequencySize--;
                }
                
                if(frequencySize == 0){                    
                    while(frequencySize == 0){ 
                        if(right - left + 1 < minWindow){
                            minWindowValue = s.substring(left, right+1);
                            minWindow = right - left + 1;
                        }
                        char leftChar = s.charAt(left);
                        if(frequency.containsKey(leftChar)){
                            frequency.put(leftChar, frequency.get(leftChar)+1);
                            if(frequency.get(leftChar) == 1){
                                frequencySize++;
                            }
                        }
                        left++;
                    }  
                }
            }
            
           
               
            
        }
        
        return minWindowValue;
    }
}