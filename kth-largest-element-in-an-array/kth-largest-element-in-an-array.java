class Solution {
    //利用 最小堆
    // 如果堆里面num 的数目 小于 k
    // 则不断push 进堆
    // 如果超过k 则检查 如果push 进的数比 堆顶的数大 则 删除堆顶的数 替换成 它 并heapify
    // 直到走完所有数为止
    public int findKthLargest(int[] nums, int k) {
        if(nums.length == 0){
            return -1;
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>(k, new Comparator<Integer>(){
            @Override
            public int compare(Integer i1, Integer i2){
                return i1 - i2;
            }
        });
        for(int i = 0; i < k; i++){
            pq.offer(nums[i]);
        }
        for(int i = k; i < nums.length; i++){
            if(nums[i] >= pq.peek()){
                pq.poll();
                pq.offer(nums[i]);
            }
        }
        return pq.peek();
    }
}