class SnakeGame {
    LinkedList<Pair<Integer,Integer>> snake;
    Set<Pair<Integer,Integer>> snakeMap;
    int width;
    int height;
    int[][] food;
    int foodPtr;

    public SnakeGame(int width, int height, int[][] food) {
        snake = new LinkedList<>();
        snakeMap = new HashSet<>();
        
        Pair<Integer,Integer> initialPoint = new Pair(0,0);
        
        snake.add(initialPoint);
        snakeMap.add(initialPoint);
        
        this.width = width;
        this.height = height;
        this.food = food;
        foodPtr = 0;        
    }
    
    public int move(String direction) {
        Pair<Integer,Integer> currHead = snake.getFirst();
        
        int dirRow = 0;
        int dirCol = 0;
        
        switch(direction){
            case "U":
                dirRow = -1;
                break;
            case "D":
                dirRow = 1;
                break;
            case "R":
                dirCol = 1;
                break;
            case "L":
                dirCol = -1;
                break;
        }
        
        int nextRow = currHead.getKey() + dirRow;
        int nextCol = currHead.getValue() + dirCol;
        Pair<Integer,Integer> newHead = new Pair<Integer,Integer>(nextRow, nextCol);
        
        if(nextRow < 0 || nextRow >= height || nextCol < 0 || nextCol >= width){
            return -1;
        }
        
        if(snakeMap.contains(newHead) && !(snake.getLast().getKey() == nextRow && snake.getLast().getValue() == nextCol)){
            return -1;
        }
        
        
        if(foodPtr < food.length && food[foodPtr][0] == nextRow && food[foodPtr][1] == nextCol){
            foodPtr++;
        }else{
            Pair<Integer, Integer> tail = snake.removeLast();
            snakeMap.remove(tail);
        }
        snake.addFirst(newHead);
        snakeMap.add(newHead);
        
        return snake.size()-1;
    }
}

/**
 * Your SnakeGame object will be instantiated and called as such:
 * SnakeGame obj = new SnakeGame(width, height, food);
 * int param_1 = obj.move(direction);
 */