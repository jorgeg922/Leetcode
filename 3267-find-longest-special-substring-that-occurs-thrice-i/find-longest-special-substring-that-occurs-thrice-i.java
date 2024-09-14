class Solution {
    public int maximumLength(String s) {
       HashMap<String, Integer> freq = new HashMap<>();
        
        
        for(int left=0; left<s.length(); left++){
            int right = left;
            while(right < s.length() && s.charAt(left) == s.charAt(right)){
                freq.put(s.substring(left,right+1), freq.getOrDefault(s.substring(left,right+1),0)+1);
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