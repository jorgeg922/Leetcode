class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for(String str : strs){
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String str_s = String.valueOf(chars);
            if(!map.containsKey(str_s)){
                map.put(str_s, new ArrayList<>());
            }
            
            map.get(str_s).add(str);
        }
        
        List<List<String>> result = new ArrayList<>();
        for(List<String> set : map.values()){
            result.add(set);
        }
        
        return result;
    }
}