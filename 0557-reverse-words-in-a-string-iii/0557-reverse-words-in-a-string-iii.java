class Solution {
    public String reverseWords(String s) {
        
        String[] words = s.split(" ");
        
        String ans = "";
        
        for(String word : words){
            StringBuilder sb = new StringBuilder(word);
            ans += sb.reverse().toString();
            ans += " ";
        }
        
        return ans.substring(0,ans.length()-1);
    }
}