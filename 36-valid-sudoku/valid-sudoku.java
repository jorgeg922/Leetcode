class Solution {
    public boolean isValidSudoku(char[][] board) {
        Set<Character>[] boardRows = new HashSet[9];
        Set<Character>[] boardCols = new HashSet[9];
        Set<Character>[] boardBoxes = new HashSet[9];
        
        for(int i=0; i<board.length; i++){
            boardRows[i] = new HashSet<>();
            boardCols[i] = new HashSet<>();
            boardBoxes[i] = new HashSet<>();
        }
        
        for(int row=0; row<board.length; row++){
            for(int col=0; col<board[0].length; col++){
                char current = board[row][col];
                if(current == '.'){
                    continue;
                }
                if(boardRows[row].contains(current)){
                    return false;
                }
                boardRows[row].add(current);
                
                if(boardCols[col].contains(current)){
                    return false;
                }
                boardCols[col].add(current);
                
                int boxIndex = (row/3)*3 + col/3;
                if(boardBoxes[boxIndex].contains(current)){
                    return false;
                }
                boardBoxes[boxIndex].add(current);
                
            }
        }
       
        return true;
    }
}