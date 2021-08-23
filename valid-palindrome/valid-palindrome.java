class Solution {
    public boolean isPalindrome(String s) {
   if(s.length() == 0 || s.length() == 1){
            return true;
        }
       
        int left = 0;
        int right = s.length() - 1;
        while(left < right){
            while(left < s.length() && !isValid(s.charAt(left))){
                    left++;
            }
            //if after delete all invalid char it is a empty string 
            if(left == s.length()){
                return true;
            }
            while(right >= 0 && !isValid(s.charAt(right))){
                right--;
            }
            if(Character.toLowerCase(s.charAt(left)) == Character.toLowerCase(s.charAt(right))){
                left++;
                right--;
                // a a b a a
            }else{
                break;
            }
        }
        

        return right <= left;
    }
    public boolean isValid (Character c){
        return Character.isAlphabetic(c) || Character.isDigit(c);
    }
}