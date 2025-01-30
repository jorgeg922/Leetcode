class Solution {
    class Robot{
        int x;
        int y;
        int i;

        public Robot(int x, int y, int i){
            this.x = x;
            this.y = y;
            this.i = i;
        }
    }
    int[][] direction = new int[][]{{0,1}, {-1,0}, {0,-1}, {1, 0}};
    public boolean isRobotBounded(String instructions) {
        
        Robot robot = new Robot(0,0,0);
    
        for(int i=0; i<4; i++){
            for(char c : instructions.toCharArray()){
                performAction(robot, c);               
            }           
        }

        if(robot.x == 0 && robot.y == 0){
            return true;
        }

        return false;
    }


    public void performAction(Robot robot, char action){
        switch(action){
                case 'L':
                    robot.i += 1;
                    if(robot.i >= direction.length){
                        robot.i = 0;
                    }
                    break;
                case 'R':
                    robot.i -= 1;
                    if(robot.i < 0){
                        robot.i = direction.length-1;
                    }
                    break;
                case 'G':
                    robot.x += direction[robot.i][0];
                    robot.y += direction[robot.i][1];
                    break;
        }
    }
}