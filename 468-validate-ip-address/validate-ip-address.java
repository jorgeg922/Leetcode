class Solution {
    public String validIPAddress(String queryIP) {
        if(queryIP.contains(".")){
            return validateIPv4(queryIP);
        }else if(queryIP.contains(":")){
            return validateIPv6(queryIP);
        }
        
        return "Neither";
    }
    
    private String validateIPv4(String queryIP){
        String[] sections = queryIP.split("\\.",-1);
        if(sections.length < 4 || sections.length > 4){
            return "Neither";
        }
        for(String section : sections){
            int num = convertToNum(section);
            if(num < 0){
                return "Neither";
            }
            if(section.charAt(0) == '0' && num > 0){
                return "Neither";
            }
            if(section.charAt(0) == '0' && section.length() > 1){
                return "Neither";
            }
            if(num > 255){
                return "Neither";
            }
        }
        
        return "IPv4";
    }
    
    private String validateIPv6(String queryIP){
        String[] sections = queryIP.split(":",-1);
        if(sections.length < 8 || sections.length > 8){
            return "Neither";
        }
        for(String section : sections){
            if(!validateIPv6Section(section)){
                return "Neither";
            }
        }
        return "IPv6";
    }
    
    private boolean validateIPv6Section(String section){
        if(section.length() < 1 || section.length() > 4){
            return false;
        }
        for(char c : section.toCharArray()){
            if(Character.isAlphabetic(c)){
                if( (c<'a' || c>'f') && (c<'A' || c>'F')){
                    return false;
                }
            }else if(!Character.isDigit(c)){
                return false;
            }    
        }
        return true;
    }
    private int convertToNum(String num){
        int convertedNumber = 0;
        try{
            convertedNumber = Integer.parseInt(num);
        }catch(Exception e){
            convertedNumber = -1;  
        }
        return convertedNumber;
    }
}