class Solution {
    List<String> ans;
    int n;
    public List<String> generateParenthesis(int n) {
        ans = new ArrayList<>();
        this.n = n;
        
        generate(0, 0, new StringBuilder());
        
        return ans;
        
    }
    
    public void generate(int opening, int closing, StringBuilder sb){
        if(sb.length() == n * 2){
            ans.add(sb.toString());
            return;
        }
        
        if(opening < n){
            sb.append('(');
            generate(opening+1, closing, sb);
            sb.deleteCharAt(sb.length()-1);

        }
        
        if(closing < opening){
            sb.append(')');          
            generate(opening, closing+1, sb);
            sb.deleteCharAt(sb.length()-1);

        }
    }
}