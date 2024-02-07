class Solution {
    public String frequencySort(String s) {
        HashMap<Character, Integer> freq = new HashMap<>();
        for(char c : s.toCharArray()){
            freq.put(c, freq.getOrDefault(c,0)+1);
        }
        
        List<Character> characters = new ArrayList<>(freq.keySet());
        Collections.sort(characters, (a,b) -> freq.get(b)-freq.get(a));
        
        StringBuilder sb = new StringBuilder();
        for(char c : characters){
            int rep = freq.get(c);
            for(int i=0; i<rep; i++){
                sb.append(c);
            }
        }
        
        return sb.toString();
    }
}