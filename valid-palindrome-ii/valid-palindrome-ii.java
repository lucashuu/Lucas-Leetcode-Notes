class Solution {
    public boolean validPalindrome(String s) {
        //贪心 delete 一个 字符 看看能不能构成回文串
        if(s.length() == 1){
            return true;
        }
        //if current string is Palindrome return ture
        if(isPalindrome(0, s.length() - 1, s));
        //two pointers find the point that the char effects palindorme 
        int[] diff = findDiff(0, s.length()-1, s);
        
        return isPalindrome(diff[0] + 1, diff[1], s) || isPalindrome(diff[0], diff[1] - 1, s); 
    }
    public boolean isPalindrome(int left, int right, String s){
        while(left < right && s.charAt(left) == s.charAt(right)){
            left++;
            right--;
        }
        return right <= left;
    }
    public int[]  findDiff(int left, int right, String s){
        while(left < right && s.charAt(left) == s.charAt(right)){
            left++;
            right--;
        }
        //return the beak point
        return new int[]{left, right};
        
    }
    
}