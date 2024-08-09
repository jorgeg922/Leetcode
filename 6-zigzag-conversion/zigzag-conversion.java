class Solution {
    public String convert(String s, int numRows) {
        if(numRows == 1){
            return s;
        }
        
        List<StringBuilder> list = new ArrayList<>();
        
        for(int i=0; i<numRows; i++){
            list.add(new StringBuilder());
        }
        
        int currentRow = 0;
        boolean goDown = false;
        
        for(char c : s.toCharArray()){
            list.get(currentRow).append(c);
            
            if(currentRow == 0 || currentRow == numRows-1){
                goDown = !goDown;
            }
            
            if(goDown) currentRow++;
            else currentRow--;
        }
        
        String ans = "";
        for(StringBuilder sb : list){
            ans += sb.toString();
        }
        
        return ans;
    }
}