class Solution {
    int maxWidth;
    public List<String> fullJustify(String[] words, int maxWidth) {
        this.maxWidth = maxWidth;
        List<String> ans = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        
        for(String word : words){
            sb.append(word);
            sb.append(" ");
            if(sb.length()-1 > maxWidth){
                String justified = justify(sb.toString().substring(0, sb.length()-word.length()-2).trim()); 
                //System.out.println(justified.length());
                ans.add(justified);
                sb = new StringBuilder();
                sb.append(word);
                sb.append(" ");
            }
            
        }
        
        if(sb.length() > 0){
            ans.add(leftJustify(sb.toString().trim()));
        }
        
        
        return ans;
    }
    
    private String leftJustify(String s){
        int numberOfCharacters = s.length();       
        int numberOfSpaces = maxWidth - numberOfCharacters;
        StringBuilder sb = new StringBuilder(s);
        for(int i=0; i<numberOfSpaces; i++){
            sb.append(" ");
        }
        return sb.toString();
    }
    private String justify(String s){
        String[] words = s.split(" ");
        
        int numberOfCharacters = (s.length() - (words.length-1));       
        int numberOfSpaces = maxWidth - numberOfCharacters;
        
        int spacesBetweenWords = 0;
        if(words.length > 1){
             spacesBetweenWords = numberOfSpaces/(words.length-1);
        }
       
        int oddSpaces = 0;
        if(words.length > 1){
            oddSpaces = numberOfSpaces%(words.length-1);
        }else{
            oddSpaces = numberOfSpaces;
        }
        
        String spaces = "";
        for(int j=0; j<spacesBetweenWords; j++){
            spaces+=" ";
        }
        
        List<String> justifiedWordArray = new ArrayList<>();
        List<Integer> spaceIndexes = new ArrayList<>();
        for(int i=0; i<words.length; i++){
            justifiedWordArray.add(words[i]);
            if(i < words.length-1){
                justifiedWordArray.add(spaces);
                spaceIndexes.add(justifiedWordArray.size()-1);
            }            
        }
        
        if(justifiedWordArray.size() == 1){
            justifiedWordArray.add("");
            spaceIndexes.add(justifiedWordArray.size()-1);
        }
        
        int spacesPtr = 0;
        while(oddSpaces > 0){
            if(spacesPtr >= spaceIndexes.size()){
                spacesPtr = 0;
            }
            String currentSpaces = justifiedWordArray.get(spaceIndexes.get(spacesPtr));
            currentSpaces += " ";
            justifiedWordArray.set(spaceIndexes.get(spacesPtr), currentSpaces);
            spacesPtr++;
            oddSpaces--;
        }
        
        StringBuilder sb = new StringBuilder();
        for(String word : justifiedWordArray){
            sb.append(word);
        }
        
        return sb.toString();
    }
}