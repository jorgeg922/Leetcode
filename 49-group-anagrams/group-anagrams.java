class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> anagrams = new HashMap<>();
        
        for(String str : strs){
            char[] arr = str.toCharArray();
            Arrays.sort(arr);
            String ss = String.valueOf(arr);
            if(!anagrams.containsKey(ss)){
                anagrams.put(ss, new ArrayList<>());
            }
            anagrams.get(ss).add(str);
        }
        
        List<List<String>> ans = new ArrayList<>();
        
        for(List<String> group : anagrams.values()){
            ans.add(group);
        }
        
        return ans;
    }
}