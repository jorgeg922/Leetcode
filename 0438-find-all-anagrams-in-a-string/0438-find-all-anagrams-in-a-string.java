class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> ans = new ArrayList<>();
        HashMap<Character,Integer> freq = new HashMap<>();
        for(char c : p.toCharArray()){
            freq.put(c, freq.getOrDefault(c,0)+1);
        }
        
        int size=freq.size();
        int left=0;
        
        for(int right=0; right<s.length(); right++){
            char current = s.charAt(right);
            if(freq.containsKey(current)){
                freq.put(current, freq.get(current)-1);
                if(freq.get(current) == 0){
                    size--;
                }
                if(freq.get(current) < 0){
                    while(freq.get(current) < 0){
                        char cl = s.charAt(left);
                        freq.put(cl, freq.get(cl) + 1);
                        if(freq.get(cl) == 1){
                            size++;
                        }
                        left++;
                    }
                }
                                
                if(size == 0){
                    ans.add(left);
                    char cl = s.charAt(left);
                    freq.put(cl, freq.get(cl)+1);
                    if(freq.get(cl) == 1){
                        size++;
                    }
                    left++;
                }
            }else{
                while(left < right){
                    char cl = s.charAt(left);
                    freq.put(cl, freq.get(cl)+1);
                    if(freq.get(cl) == 1){
                        size++;
                    }
                    left++;
                }
                left = right+1;
            }     
        }
       
        return ans;
    }
}