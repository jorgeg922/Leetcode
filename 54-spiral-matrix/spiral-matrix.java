class Solution {
    int[][] matrix;
    int row;
    int col;
    int rows;
    int cols;
    boolean[][] visited;
    int count;
    List<Integer> ans;
    public List<Integer> spiralOrder(int[][] matrix) {
        ans = new ArrayList<>();
        this.matrix = matrix;
        rows = matrix.length;
        cols = matrix[0].length;
        row = 0;
        col = 0;
        visited = new boolean[rows][cols];
        
        
        boolean right = true;
        boolean down = true;
        ans.add(matrix[0][0]);
        visited[0][0] = true;
        
        while(count < (rows * cols)-1){
            System.out.println(count);
            if(right){
                
                col = goRight(row, col+1);
                right = false;
            }
            
            if(down){
                row = goDown(row+1,col);
                down = false;
            }
            
            if(!right){
                col = goLeft(row,col-1);
                right = true;
            }
            
            if(!down){
                row = goUp(row-1,col);
                down = true;
            }
        }        
        return ans;
    }
    
    public int goRight(int row, int col){
        while(col<cols && !visited[row][col]){
            visited[row][col] = true;
            ans.add(matrix[row][col++]);
            
            count++;
        }
        return col-1;
    }
    
    public int goDown(int row, int col){
        while(row < rows && !visited[row][col]){
            visited[row][col] = true;
            ans.add(matrix[row++][col]);
            
            count++;
        }       
        return row-1;
    }
    
    public int goLeft(int row, int col){
        while(col >= 0 && !visited[row][col]){
            visited[row][col] = true;
            ans.add(matrix[row][col--]);
            
            count++;
        }
        return col + 1;
    }
    
    public int goUp(int row, int col){
        while(row >= 0 && !visited[row][col]){
            visited[row][col] = true;
            ans.add(matrix[row--][col]);
            
            count++;
        }
        return row +1;
    }
}