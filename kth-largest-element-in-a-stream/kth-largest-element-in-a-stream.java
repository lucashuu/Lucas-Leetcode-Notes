class KthLargest {
    //Build a mini Heap with size K
    //If the new value >= the the top one pop the top one 
    //And add it to Heap
    private PriorityQueue<Integer> pq;
    int k = 0;
    public KthLargest(int k, int[] nums) {
        pq = new PriorityQueue<Integer>(k, new Comparator<Integer>(){
            public int compare(Integer l1, Integer l2){
                return l1 - l2;
            }
        });
        this.k = k;
        for (int i = 0; i < nums.length && i < k; i++) {
            // 将 nums 的前 k 个数（如有）入堆
            this.pq.add(nums[i]);
        }

        for (int i = k; i < nums.length; i++) {
            // 将 nums 剩余的数（如有）依次和堆顶元素比较
            // 动态维护堆的 size 为 k
            if (nums[i] > this.pq.peek()) {
                this.pq.poll();
                this.pq.add(nums[i]);
            }
        }

            
    }
    
    public int add(int val) {
        if (pq.size() < k) {
            pq.offer(val);
        } else if (pq.peek() <= val) {
            pq.poll();
            pq.offer(val);
        }

        return pq.peek();


    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */