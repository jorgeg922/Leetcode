class Solution {
    public int minimumMoves(String s) {
        int[] neighbors = new int[]{1,2};
        
        char[] letters = s.toCharArray();
        
        int moves = 0;
        
        for(int i=0; i<letters.length; i++){
            int next = i + neighbors[0];
            int next2 = i + neighbors[1];
            
            if(letters[i] != 'X'){
                continue;
            }
            
            moves++;
            
            if(next < letters.length){
                letters[next] = 'O';
            }
            if(next2 < letters.length){
                letters[next2] = 'O';
            }
        }
        
        return moves;
    }
}