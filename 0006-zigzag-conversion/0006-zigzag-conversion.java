class Solution {
    public String convert(String s, int numRows) {
        if(numRows == 1){
            return s;
        }
        List<List<Character>> tmp = new ArrayList<>();        
        for(int i=0; i<numRows; i++){
            tmp.add(new ArrayList<>());
        }
        
        int currRow = -1;
        boolean goingDown = true;
        for(int i=0; i<s.length(); i++){    
            if(goingDown){
                currRow++;
            }else{
                currRow--;
            }
            if(currRow == numRows){
                goingDown = false;
                currRow=numRows-1;
                currRow--;
                
            }else if(currRow < 0){
                goingDown = true;
                currRow=0;
                currRow++;
            }
                     
            char c = s.charAt(i);
            tmp.get(currRow).add(c);
           
            
        }
        
        StringBuilder sb = new StringBuilder();
        for(List<Character> line : tmp){
            for(char c : line){
                sb.append(c);
            }
        }
        
        return sb.toString();
    }
}