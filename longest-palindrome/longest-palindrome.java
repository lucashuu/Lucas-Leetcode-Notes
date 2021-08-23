class Solution {
    public int longestPalindrome(String s) {
        // 消消乐
        // 创建一个hashMap 如果当前char 存在 在hashmap中且不等于0， 则-- 并push back， 且count + 2。 类似与里面有一个char 遇到一个相同的 消除掉 并且给最长长度         +2
        // 如果map里没有 则push 1 
        //循环完所有char
        //从map中找到一个为1的char 加入结果中 返回长度
        if(s.length() == 0 || s.length() == 1){
            return 1;
        }
        HashMap<Character, Integer> map = new HashMap<>();
        int maxlen = 0;
        for(int i = 0; i < s.length(); i++){
            int count = map.getOrDefault(s.charAt(i), 0);
            count++;
            if(count == 2){
                maxlen += 2;
                map.put(s.charAt(i), 0);
            }else if(count == 1){
                map.put(s.charAt(i), 1);
            }
        }
        for(int index : map.values()){
            if(index == 1){
                return maxlen + 1;
            }
        }
        return maxlen;  
    }
}