class SnakeGame {
    int height;
    int width;
    int[][] food;
    int currFoodIndex;
    LinkedList<Pair<Integer,Integer>> snake;
    Set<Pair<Integer,Integer>> snakeMap;
    public SnakeGame(int width, int height, int[][] food) {
        this.height = height;
        this.width = width;
        this.food = food;
        this.currFoodIndex = 0;
        this.snake = new LinkedList<>();
        snake.addFirst(new Pair<Integer,Integer>(0,0));
        this.snakeMap = new HashSet<>();
        snakeMap.add(new Pair<Integer,Integer>(0,0));
    }
    
    public int move(String direction) {
        Pair<Integer,Integer> head = snake.getFirst();
        int headRow = head.getKey();
        int headCol = head.getValue();
        switch(direction){
            case "R":
                headCol++;
                break;
            case "D":
               headRow++;
                break;
            case "U":
                headRow--;
                break;
            case "L":
                headCol--;
                break;
        }
        
        Pair<Integer,Integer> newHead = new Pair<Integer,Integer>(headRow,headCol);
        Pair<Integer,Integer> tail = snake.getLast();
        if(headRow < 0 || headRow >= height || headCol < 0 || headCol >= width){
            return -1;
        }
        
        if(snakeMap.contains(newHead) && !(newHead.getKey() == tail.getKey() && newHead.getValue() == tail.getValue()))         {
            return -1;
        }
           
        if(currFoodIndex < food.length && food[currFoodIndex][0] == newHead.getKey() && food[currFoodIndex][1] == newHead.getValue()){
            currFoodIndex++;
            
        }else{
            snake.removeLast();
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