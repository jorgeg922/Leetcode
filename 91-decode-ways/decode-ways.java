import java.util.*;

class Solution {
    // Memoization map to store previously computed results
    HashMap<Integer, Integer> memo;

    public int numDecodings(String s) {
        if (s == null || s.length() == 0)
            return 0;
        memo = new HashMap<>();
        
        return backtrack(0, s);
    }
    
    public int backtrack(int index, String s) {
        if (memo.containsKey(index)){
          return memo.get(index);  
        }
        
        // Base case: If index reaches end of string, return 1
        if (index == s.length())
            return 1;
        
        // If the current character is '0', there's no valid decoding
        if (s.charAt(index) == '0')
            return 0;
        
        int ways = 0;
        
        // Decode single digit
        ways += backtrack(index + 1, s);
        
        // Decode two digits if valid
        if (index + 1 < s.length() && (s.substring(index, index + 2).compareTo("26") <= 0)){
            ways += backtrack(index + 2, s);
        }
            
        
        // Store the result for this index in memoization map
        memo.put(index, ways);
        
        return ways;
    }
}
