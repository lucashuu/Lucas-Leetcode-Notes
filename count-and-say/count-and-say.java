// 则则是对于连续字符串，表示为重复次数+数本身。那么其中的核心过程则是根据上一个字符串求得下一个字符串，从 '1' 开始迭代 n - 1 次即可。
class Solution {
    public String countAndSay(int n) {
        if( n <= 0){
            return null;
        }  
        StringBuilder currSeq = new StringBuilder("1");
        for (int i = 1; i < n; i++) {
            currSeq = getNextSeq(currSeq);
        }
        return currSeq.toString();
    }
   private StringBuilder getNextSeq(StringBuilder seq) {
        StringBuilder nextSeq = new StringBuilder();
        int cnt = 1;
        for(int i = 0; i < seq.length(); i++){
            if(i + 1 < seq.length() && seq.charAt(i) == seq.charAt(i + 1)){
                cnt++;
            }else{
                nextSeq.append(cnt).append(seq.charAt(i));
                cnt = 1;
            }
        }
       return nextSeq;
    }
}