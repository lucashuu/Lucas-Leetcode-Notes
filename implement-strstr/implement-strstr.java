//遍历source string 和目标 string
//遍历source string 仅有可能出现目标string的地方 当source string 剩余长度不够的时候就不用继续遍历
//注意边界
class Solution {
    public int strStr(String haystack, String needle) {
        if(haystack == null && needle == null){
            return 0;
        }else if(haystack == null){
            return -1;
        }else if(needle == null){
            return 0;
        }
        for(int i = 0; i <haystack.length() - needle.length() + 1; i++){
            int j = 0;
            for(; j < needle.length(); j++){
                if(haystack.charAt(i + j) != needle.charAt(j)){
                    break;
                  } 
                }
            if(j == needle.length()){
                    return i;
            }
        }
        return -1;
    }
}