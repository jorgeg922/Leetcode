class Solution {
    public int reverse(int x) {
        
        String curr = String.valueOf(x);
        StringBuilder reversed = new StringBuilder();
        
        if(curr.charAt(0) == '-'){
            reversed.append('-');
            curr = curr.substring(1);
        }
        
        for(int i=curr.length()-1; i>=0; i--){
            reversed.append(curr.charAt(i));
        }
        
        String reversedNum = reversed.toString();
       
        try{
            int ans = Integer.parseInt(reversedNum);
            return ans;
        }catch(Exception e){
            return 0;
        }
        
        
    }
}