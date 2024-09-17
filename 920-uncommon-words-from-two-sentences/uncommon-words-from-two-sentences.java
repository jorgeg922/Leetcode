class Solution {
    public String[] uncommonFromSentences(String s1, String s2) {
        Map<String, Integer> frequency = new HashMap<>();
        
        String[] s1_arr = s1.split(" ");
        String[] s2_arr = s2.split(" ");
        
        for(String str : s1_arr){
            frequency.put(str, frequency.getOrDefault(str,0)+1);
        }
        
        for(String str : s2_arr){
            frequency.put(str, frequency.getOrDefault(str,0)+1);
        }
        
        List<String> ans = new ArrayList<>();
        for(Map.Entry<String,Integer> entry : frequency.entrySet()){
            if(entry.getValue() == 1){
                ans.add(entry.getKey());
            }
        }
        
        return ans.toArray(new String[0]);
    }
}