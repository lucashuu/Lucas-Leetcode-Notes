//从后往前 遍历 String 遇到 空格 则返回 string 长度
class Solution {
    public int lengthOfLastWord(String s) {
        if(s.length() == 0 || s == null){
            return 0;
        }
        if(s.isEmpty()){
            return 0;
        }
        int len = 0;
        s = s.trim();
        for(int i = s.length() - 1; i >= 0; i--){
            if(s.charAt(i) == ' '){
                return len;
            }else{
                len++;
            }
        }
        return len;
    }
}