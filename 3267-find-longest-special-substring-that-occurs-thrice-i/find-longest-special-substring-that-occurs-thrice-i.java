class Solution {
    public int maximumLength(String s) {
       HashMap<String, Integer> freq = new HashMap<>();
        
        
        for(int left=0; left<s.length(); left++){
            String sub = s.substring(left, left+1);
            freq.put(sub, freq.getOrDefault(sub,0)+1);
            
            int right = left+1;
            StringBuilder sb = new StringBuilder();
            sb.append(sub);
            while(right < s.length()){
                if(sb.charAt(sb.length()-1) == s.charAt(right)){
                    sb.append(s.charAt(right));
                    freq.put(sb.toString(), freq.getOrDefault(sb.toString(),0)+1);
                    
                }else{
                    break;
                }
                right++;
            }
            

        }
        
        int len = 0;
        for(Map.Entry<String,Integer> entry : freq.entrySet()){
            if(entry.getValue() >= 3){
                if(entry.getKey().length() > len){
                    len = entry.getKey().length();
                }
            }
        }
        
        return len==0?-1:len;
    }
}