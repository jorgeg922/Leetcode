class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String,List<String>> anagramGroups = new HashMap<>();
        
        for(String str : strs){
            char[] decomposedStr = str.toCharArray();
            Arrays.sort(decomposedStr);
            String recreatedStr = String.valueOf(decomposedStr);
            if(!anagramGroups.containsKey(recreatedStr)){
                anagramGroups.put(recreatedStr, new ArrayList<>());
            }
            anagramGroups.get(recreatedStr).add(str);
        }
        
        List<List<String>> groupedAnagrams = new ArrayList<>();
        for(List<String> group : anagramGroups.values()){
            groupedAnagrams.add(group);
        }
        
        return groupedAnagrams;
    }
}