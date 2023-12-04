class Solution {
    public String longestCommonPrefix(String[] strs) {
        if(strs == null || strs.length == 0){
            return "";
        }
        String s = "";
        int minLen = Integer.MAX_VALUE;
        for(String str : strs){
            if(str.length() < minLen){
                s = str;
                minLen = str.length();
            }
        }
        
        int left = 0;
        int right = s.length();
        
        while(left <= right){
            int mid = left + (right-left)/2;
            
            if(isCommonPrefix(strs,mid)){
                left = mid + 1;
            }else{
                right = mid - 1;
            }
        }
        //int index = (left+right)/2;
        return s.substring(0,right);
       
    }
    
    public boolean isCommonPrefix(String[]strs, int len){
        String prefix = strs[0].substring(0,len);
        for(String s : strs){
            if(!s.startsWith(prefix)){
                return false;
            }
        }
        
        return true;
    }
    
}