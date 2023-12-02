class Solution {
    public boolean backspaceCompare(String s, String t) {
        StringBuilder sf = new StringBuilder();
        StringBuilder tf = new StringBuilder();
        
       for(int i=0; i<s.length(); i++){
           char c = s.charAt(i);
           
           if(c == '#'){
               if(sf.length() > 0){
                  sf.deleteCharAt(sf.length()-1); 
               }               
           }else{
               sf.append(c);
           }
       }
        
        
        for(int i=0; i<t.length(); i++){
           char c = t.charAt(i);
           
           if(c == '#'){
               if(tf.length() > 0){
                  tf.deleteCharAt(tf.length()-1); 
               }         
           }else{
                tf.append(c);
            }     
       }
        
        
        return sf.toString().equals(tf.toString());
    }
}