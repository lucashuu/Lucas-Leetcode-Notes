//用数组计算每个字符出现的次数
//s里面出现则++ t里面出现则--
class Solution {
    public boolean isAnagram(String s, String t) {
        if(s == null || t == null) return false;
        if (s.length() != t.length()) return false;
        
        int[] check = new int[26];
        for(int i = 0; i < s.length(); i++){
            check[s.charAt(i) - 'a']++;
            check[t.charAt(i) - 'a']--;
        }
        for(int j = 0 ; j < 26; j++){
            if(check[j] != 0){
                return false;
            }
        }
        return true;
    }
}