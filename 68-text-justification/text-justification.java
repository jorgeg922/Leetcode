class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> ans = new ArrayList<>();
        
        List<String> line = new ArrayList<>();
        int lineLen = 0;
        StringBuilder sb = new StringBuilder();
        
        for(String word : words){
            int wordLen = word.length();
            sb.append(word);
            sb.append(" ");
            if(sb.length() - 1 > maxWidth){
                String currLine = sb.toString().substring(0, sb.length()-wordLen-2);               
                String justified = justify(currLine, maxWidth);
                ans.add(justified);                
                sb = new StringBuilder(word);
                sb.append(" ");
            }
        }
        
        if(sb.length() > 0){
            String leftJustified = leftJustify(sb.toString().trim(), maxWidth);
            ans.add(leftJustified);
        }
        
        return ans;
    }
    
    public String leftJustify(String line, int maxWidth){
        int spacesNeeded = maxWidth - line.length();
        
        StringBuilder sb = new StringBuilder(line);
        for(int i=0; i<spacesNeeded; i++){
            sb.append(" ");
        }
        
        return sb.toString();
    }
    
    public String justify(String line, int maxWidth){
        String[] words = line.split(" ");
        int numberOfCharacters = line.length() - (words.length-1);
        int numberOfSpaces = maxWidth-numberOfCharacters;
        
        int spacesBetweenWords = 0;
        if(words.length > 1){
          spacesBetweenWords = numberOfSpaces/(words.length-1);  
        }
        
        int oddSpaces = 0;
        if(words.length > 1){
            oddSpaces = numberOfSpaces % (words.length-1);
        }else{
            oddSpaces = numberOfSpaces;
        }
        
        List<String> lineWithSpaces = new ArrayList<>();
        List<Integer> spaceIndexes = new ArrayList<>();
        
        String space = "";
        for(int i=0; i<spacesBetweenWords; i++){
            space += " ";
        }
        
        for(int i=0; i<words.length; i++){
            lineWithSpaces.add(words[i]);
            if(i < words.length-1){
                lineWithSpaces.add(space);
                spaceIndexes.add(lineWithSpaces.size()-1);
            }
        }
        
        if(lineWithSpaces.size() == 1){
            lineWithSpaces.add("");
            spaceIndexes.add(lineWithSpaces.size()-1);
        }
        
        int ptr = 0;
        while(oddSpaces > 0){
            if(ptr >= spaceIndexes.size()){
                ptr = 0;
            }
            String currSpace = lineWithSpaces.get(spaceIndexes.get(ptr));
            currSpace += " ";
            lineWithSpaces.set(spaceIndexes.get(ptr), currSpace);
            oddSpaces--;
            ptr++;
        }
        
        StringBuilder sb = new StringBuilder();
        
        for(String val : lineWithSpaces){
            sb.append(val);
        }
        
        return sb.toString();
        
    }
}