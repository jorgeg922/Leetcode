class Solution {
    public String reverseWords(String s) {
        StringBuilder sb = new StringBuilder();
        String[] words = s.split("\\W+");
        
        for(int i=words.length-1; i>=0; i--){
            sb.append(words[i] + " ");
        }
        
        return sb.toString().trim();
    }
}