class Solution {
    public boolean isPalindrome(int x) {
        String number = Integer.toString(x);
        StringBuilder sb = new StringBuilder(number);
        return sb.reverse().toString().equals(number);
    }
}