class Solution {
    public String numberToWords(int num) {
        Map<Integer, String> nomenclature = new HashMap<>();
        if(num == 0){
            return "Zero";
        }
        
        nomenclature.put(1, "One");
        nomenclature.put(2, "Two");
        nomenclature.put(3, "Three");
        nomenclature.put(4, "Four");
        nomenclature.put(5, "Five");
        nomenclature.put(6, "Six");
        nomenclature.put(7, "Seven");
        nomenclature.put(8, "Eight");
        nomenclature.put(9, "Nine");
        nomenclature.put(10, "Ten");
        nomenclature.put(11, "Eleven");
        nomenclature.put(12, "Twelve");
        nomenclature.put(13, "Thirteen");
        nomenclature.put(14, "Fourteen");
        nomenclature.put(15, "Fifteen");
        nomenclature.put(16, "Sixteen");
        nomenclature.put(17, "Seventeen");
        nomenclature.put(18, "Eighteen");
        nomenclature.put(19, "Nineteen");
        nomenclature.put(20, "Twenty");
        nomenclature.put(30, "Thirty");
        nomenclature.put(40, "Forty");
        nomenclature.put(50, "Fifty");
        nomenclature.put(60, "Sixty");
        nomenclature.put(70, "Seventy");
        nomenclature.put(80, "Eighty");
        nomenclature.put(90, "Ninety");
        nomenclature.put(100, "One Hundred");
        nomenclature.put(1000, "One Thousand");
        nomenclature.put(1000000, "One Million");
        
        if(nomenclature.containsKey(num)){
            return nomenclature.get(num);
        }
        
        String digits = String.valueOf(num);
        List<String> sets = new ArrayList<>();
        
        int commas = (digits.length()-1)/3;
        
        int left = digits.length();
        int right = digits.length();
        
        while(left >= 0){
            if(right - left == 3){
                sets.add(digits.substring(left, right));
                right = left;
            }
            left--;
        }
        if(right > 0){
            sets.add(digits.substring(0, right));
        }
        
        String ans = "";
        for(int i=sets.size()-1; i>=0; i--){
            String subset = sets.get(i);
            subset = String.valueOf(Integer.parseInt(subset));
            if(nomenclature.containsKey(Integer.parseInt(subset))){
                ans += " " + nomenclature.get(Integer.parseInt(subset));
            }else{
                int subsetPtr = 0;
                while(subsetPtr < subset.length()){
                    if(subset.length() == 3 && subsetPtr == 0){
                        ans += " " + nomenclature.get(Character.getNumericValue(subset.charAt(subsetPtr))) + " Hundred";
                    }else if(subset.length() - subsetPtr == 2 && nomenclature.containsKey(Integer.parseInt(subset.substring(subsetPtr)))){
                        ans += " " + nomenclature.get(Integer.parseInt(subset.substring(subsetPtr)));
                        break;
                    }else if(Character.getNumericValue(subset.charAt(subsetPtr)) == 0){
                        subsetPtr++;
                        continue;
                    }else{
                        int dig = (int) Math.pow(10, subset.length()-subsetPtr-1) * Character.getNumericValue(subset.charAt(subsetPtr));
                        ans += " " + nomenclature.get(dig);
                    }   
                    subsetPtr++;
                }                
            }
            
            if(subset.equals("0")){
                commas--;
                continue;
            }
            
            if(commas == 3){
                ans += " " + "Billion";
                commas--;
            }else if(commas == 2){
                ans += " " + "Million";
                commas--;
            }else if(commas == 1){
                ans += " " + "Thousand";
                commas--;
            }
        }
        
        return ans.trim();
    }
}