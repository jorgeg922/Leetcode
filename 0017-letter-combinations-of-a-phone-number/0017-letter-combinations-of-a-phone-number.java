class Solution {
    List<String> combinations;
    HashMap<Character, List<Character>> mapping;
    public List<String> letterCombinations(String digits) {
        if(digits.length() == 0){
            return new ArrayList<String>();
        }
        combinations = new ArrayList<>();
        mapping = new HashMap<>();
        mapping.put('2', Arrays.asList('a','b','c'));
        mapping.put('3', Arrays.asList('d','e','f'));
        mapping.put('4', Arrays.asList('g','h','i'));
        mapping.put('5', Arrays.asList('j','k','l'));
        mapping.put('6', Arrays.asList('m','n','o'));
        mapping.put('7', Arrays.asList('p','q','r','s'));
        mapping.put('8', Arrays.asList('t','u','v'));
        mapping.put('9', Arrays.asList('w','x','y','z'));
        findCombinations(digits, 0, new StringBuilder());
        return combinations;
    }
    
    private void findCombinations(String digits, int index, StringBuilder sb){
        if(sb.length() == digits.length()){
            combinations.add(sb.toString());
            return;
        }
        
        List<Character> l = mapping.get(digits.charAt(index));
        for(char letter : l){
                sb.append(letter);
                findCombinations(digits,index+1,sb);
                sb.deleteCharAt(sb.length()-1);
        }
    }
}