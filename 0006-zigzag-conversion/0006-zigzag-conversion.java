class Solution {
    public String convert(String s, int numRows) {
        if(numRows == 1){
            return s;
        }
        
        List<StringBuilder> tmp = new ArrayList<>(); 
        
        for(int i=0; i<numRows; i++){
            tmp.add(new StringBuilder());
        }
        
        int currRow = 0;
        boolean goingDown = false;
        
        for(int i=0; i<s.length(); i++){  
            char c = s.charAt(i);
            tmp.get(currRow).append(c);
            
            if(currRow == 0 || currRow == numRows-1){
                goingDown = !goingDown;
                
            }
            
            if(goingDown){
                currRow++;
            }else{
                currRow--;
            }
        }
        
        String ans = "";
        for(StringBuilder line : tmp){
            ans += line.toString();
        }
        
        return ans;
    }
}