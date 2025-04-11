class Solution {
    public int lengthOfLastWord(String s) {
        int wordBegin = s.length()-1;

        while(wordBegin >= 0 && Character.isWhitespace(s.charAt(wordBegin))){
            wordBegin--;
        }

        int wordEnd = wordBegin;
        while(wordEnd >= 0 && !Character.isWhitespace(s.charAt(wordEnd))){
            wordEnd--;
        }

        return wordBegin - wordEnd;

    }
}