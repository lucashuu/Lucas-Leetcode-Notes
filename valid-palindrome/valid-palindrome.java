//双指针 一左一右
//如果是字母再往左/右移动  Character.isLetterOrDigit
//所有字母转换为lower case Character.toLowerCase
class Solution {
    public boolean isPalindrome(String s) {
        if(s == null || s.length() == 0){
            return true;
        }
        int l = 0;
        int r = s.length() - 1;
        while (l < r){
            if(!Character.isLetterOrDigit(s.charAt(l))){
                l++;
                continue;
            }
            if(!Character.isLetterOrDigit(s.charAt(r))){
                r--;
                continue;
            }
            if(Character.toLowerCase(s.charAt(l)) == Character.toLowerCase(s.charAt(r))){
                l++;
                r--;
            }else{
                return false;
            }
        }
        return true;
    }
}