class newChar {
        int count;//出现的频率
        char letter;//字母

        public newChar(int count, char letter) {
            this.count = count;
            this.letter = letter;
        }
}
class Solution {
    //建一个大顶堆
    //建立一个hashmap 遍历所有的数
    //把他们出现的次数记录在 map里
    //定义一个new char 类 由字母 和 出现的次数组成
    //把所有的new char 都加入到堆里
    //每次poll（） 出来top的两个值 保证出现次数最多的字母 不会连在一起
    //count-- 后 如果 count 还是 > 0 则重新加入到 堆里
    public String reorganizeString(String s) {
        if(s.length() == 0 || s == null){
            return null;
        }
        PriorityQueue<newChar> pq = new PriorityQueue<newChar>(26, new Comparator<newChar>(){
            public int compare (newChar a, newChar b){
                return b.count - a.count;
            }
        });
        
         int[] counts = new int[26];
        for (int i = 0; i < s.length(); i++) {
            counts[s.charAt(i) - 'a']++;
        }
        // add char to Heap
        for (int i = 0; i < 26; i++) {
            //判断重构是否可行，counts[i] <= (S.length() + 1) / 2)---某个字母过半就不能重构
            if (counts[i] > 0 && counts[i] <= (s.length() + 1) / 2) {
                //可以重构，就往大顶堆里面塞对象
                pq.add(new newChar(counts[i], (char) (i + 'a')));
            } else if (counts[i] > (s.length() + 1) / 2) {
                return "";
            }
        }
        StringBuilder sb = new StringBuilder();
        // 每次poll 两个出来 奇数个 会剩一个
        while(pq.size() > 1){
            newChar a = pq.poll();
            newChar b = pq.poll();
            sb.append(a.letter);
            sb.append(b.letter);
            if (--a.count > 0) pq.add(a);
            if (--b.count > 0) pq.add(b);
        }
        if(pq.size() > 0){
            sb.append(pq.poll().letter);
        }
        return sb.toString();
        
    }
}