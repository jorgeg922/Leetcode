class Solution {
    public String gcdOfStrings(String str1, String str2) {
        if(str1.length() < str2.length()){
            return gcdOfStrings(str2,str1);
        }
        
        int rightBound = str2.length();
        int largestStringLen = -1;
        String largestString = "";
        
        for(int i=rightBound-1; i>=0; i--){
            String sub = str2.substring(i,rightBound);
            if(divide(str2, sub) && divide(str1, sub)){
                if(sub.length() > largestStringLen){
                    largestStringLen = sub.length();
                    largestString = sub;
                }
            }
        }
        
        return largestString;
    }
    
    public boolean divide(String s, String x){
        int len = x.length();
        int i=0;
        for(i=0; i<=s.length()-len; i+=len){
            String test = s.substring(i,i+len);
            if(!test.equals(x)){
                return false;
            }
        }
        if(i == s.length()){
            return true;
        }
        return false;
    }
}