// odd : s a s   a 的左边和右边
// even : a ss a ss 的左边和右边
class Solution {
    public String longestPalindrome(String s) {
        if(s == null || s.length() == 0){
            return "";
        }
        int longest = 0;
        int left = 0;
        for(int i = 0; i < s.length(); i++){
            //odd
            int leftIndex = leftPalindrome(s, i , i);
            int plen = 2 * (i - leftIndex) + 1;
            if(plen > longest){
                left = leftIndex;
                longest = plen;
            }
            //even 
            leftIndex = leftPalindrome(s, i , i + 1);
            plen = 2 *(i - leftIndex + 1);
            if(plen > longest){
                left = leftIndex;
                longest = plen;
            }
        }
         return s.substring(left, left + longest);
    }
    public int leftPalindrome(String s, int left, int right){
        while(right < s.length() && left >= 0 && s.charAt(left) == s.charAt(right)){
            left--;
            right++;
        }
        return left + 1;
    }
}