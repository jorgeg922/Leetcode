class Solution {
    public String convert(String s, int numRows) {
        if(numRows == 1){
            return s;
        }
        List<StringBuilder> list = new ArrayList<>();
        int currRow = 0;
        
        for(int i=0; i<numRows; i++){
            list.add(new StringBuilder());
        }
        
        boolean goDown = false;
        
        for(char c : s.toCharArray()){  
            
            list.get(currRow).append(c);
            if(currRow == 0 || currRow == numRows-1){
                goDown = !goDown;
            }
            
            if(goDown) currRow++;
            else currRow--;
        }
        
        String ans = "";
        for(StringBuilder sb : list){
            ans += sb.toString();
        }
        
        return ans;
    }
}