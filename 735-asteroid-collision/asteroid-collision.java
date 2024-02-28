class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();
        
        for(int asteroid : asteroids){
            boolean addAsteroid = true;
            while(!stack.isEmpty() && (stack.peek() > 0 && asteroid < 0)){
                if(Math.abs(stack.peek()) < Math.abs(asteroid)){
                    stack.pop();
                    continue;
                }
                else if (Math.abs(stack.peek()) == Math.abs(asteroid)){
                    stack.pop();
                }
                addAsteroid = false;
                break;
            }
            
            if(addAsteroid){
                stack.push(asteroid);
            }
            
           
        }
        
        List<Integer> ans = new ArrayList<>();
        
        while(!stack.isEmpty()){
           ans.add(stack.pop());    
        }
        Collections.reverse(ans);
        return ans.stream().mapToInt(i->i).toArray();
    }
}