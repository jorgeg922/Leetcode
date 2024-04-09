class Solution {
    public String largestNumber(int[] nums) {
        String[] numsS = new String[nums.length];
        for(int i=0; i<nums.length; i++){
            numsS[i] = String.valueOf(nums[i]);
        }
        
        Arrays.sort(numsS, new Comparator<>(){
           public int compare(String a, String b){
               String as = a + b;
               String bs = b + a;
               
               return bs.compareTo(as);
           } 
        });
        
        if(numsS[0].equals("0")){
            return "0";
        }
        
        StringBuilder sb = new StringBuilder();
        for(String s : numsS){
            sb.append(s);
        }
        
        return sb.toString();
    }
}