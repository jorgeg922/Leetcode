class Solution {
    int rows;
    int cols;
    int count; 
    int[][] matrix;
    boolean[][] visited;
    
    public List<Integer> spiralOrder(int[][] matrix) {
        this.matrix = matrix;
        List<Integer> ans = new ArrayList<>();
        
        rows = matrix.length;
        cols = matrix[0].length;
        count = rows * cols;
        
        visited = new boolean[rows][cols];
        
        int row = 0;
        int col = 0;
        boolean right = true;
        boolean down = true;
        
        ans.add(matrix[0][0]);
        visited[0][0]=true;
        count--;
        
        while(count > 0){
            if(right){
                col = goRight(row,col+1,ans)-1;
                right = false;
            }

            if(down){                
                row = goDown(row+1,col,ans)-1 ;
                down = false;
            }

            if(!right){                
                col = goLeft(row,col-1,ans)+1;
                right = true;
            }

            if(!down){
                row = goUp(row-1,col,ans)+1;
                down=true;
            }        
        }
        
        return ans;
    }
    
    public int goRight(int row, int col, List<Integer> ans){
        while(col < cols && !visited[row][col]){
            visited[row][col] = true;
            ans.add(matrix[row][col++]);
            count--;
        }
        return col;
    }
    
    public int goDown(int row, int col, List<Integer> ans){
        while(row < rows && !visited[row][col]){
            visited[row][col] = true;
            ans.add(matrix[row++][col]);
            count--;
        }
        return row;
    }
    
    public int goLeft(int row, int col, List<Integer> ans){
        while(col >= 0  && !visited[row][col]){
            visited[row][col] = true;
            ans.add(matrix[row][col--]);
            count--;
        }
        
        return col;
    }
    
    public int goUp(int row, int col, List<Integer> ans){
        while(row >=0 && !visited[row][col]){
            visited[row][col]=true;
            ans.add(matrix[row--][col]);
            count--;
        }
        return row;
    }
}