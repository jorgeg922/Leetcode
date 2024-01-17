class Solution {
    public boolean isValidSudoku(char[][] board) {
        List<Set<Character>> rows = new ArrayList<>();
        List<Set<Character>> cols = new ArrayList<>();
        List<Set<Character>> block = new ArrayList<>();
        for(int i=0; i<board.length; i++){
            rows.add(new HashSet<Character>());
            cols.add(new HashSet<Character>());
            block.add(new HashSet<Character>());
        }
        
        for(int i=0; i<board.length; i++){
            for(int j=0; j<board[0].length; j++){
                char val = board[i][j];
                if(val == '.'){
                    continue;
                }
                
                Set<Character> currRow = rows.get(i);
                Set<Character> currCol = cols.get(j);
                Set<Character> currBlock = block.get((i/3)* 3  + (j/3));
                
                if(currRow.contains(val) || currCol.contains(val) || currBlock.contains(val)){
                    return false;
                }
                
                currRow.add(val);
                currCol.add(val);
                currBlock.add(val);                               
            }
        }
        
        return true;
    }
}