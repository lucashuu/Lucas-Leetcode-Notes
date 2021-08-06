class Solution {
    //思路
    //维护一个最小堆
    // 按开始时间正序排序
    // 才能正确的遍历
    //如果堆为空 把 第一个时间interval 的结束时间放进去
    // 如果不为空 检查 新的开始时间 如果大于 堆顶 则更新 结束时间为 则interval 的结束时间
    // 如果小于堆顶 则push 进堆 （创建一个新的房间）
    // 遍历结束后 返回 堆的大小
    public int minMeetingRooms(int[][] intervals) {
        if(intervals.length == 0 || intervals == null){
            return -1;
        }
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>(intervals.length,  new Comparator<Integer>(){
          public int compare(Integer l1,Integer l2){
              return l1 - l2;
          }  
        });
        Arrays.sort(intervals, new Comparator<int[]>(){
            public int compare(int[] l1, int[] l2){
                return l1[0] - l2[0];
            }
        });
         pq.offer(intervals[0][1]);
        for(int i = 1; i < intervals.length; i++){
         
                if(intervals[i][0] >= pq.peek()){
                    pq.poll();
                    pq.offer(intervals[i][1]);
                }else{
                    pq.offer(intervals[i][1]);
                }
            }
        
        return pq.size();
    }
}