class Solution {
    //维护一个hash 和 mini Heap 
    // 先遍历 k 个元素 并push 进 heap 
    // hashmap 记下出现的次数
    // 如果新的元素 map中的次数大于 堆顶 则push 进堆 
    public int[] topKFrequent(int[] nums, int k) {
        if(nums.length == 0 || nums ==  null){
            return null;
        }
        int[] res = new int [k];
        HashMap<Integer, Integer> map = new HashMap<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>(k, new Comparator<Integer>(){
             @Override
            public int compare(Integer a, Integer b) {
                return map.get(a) - map.get(b);
            }
        });
        int i = 0;
        while(i < nums.length){
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
            i++;
        }
        
        for(int j = 0; j < nums.length; j++){
            if(pq.size() < k){
                if(!pq.contains(nums[j])){
                pq.offer(nums[j]);
                }
            }
            else if(map.get(nums[j]) > map.get(pq.peek())){
                    if(!pq.contains(nums[j])){
                    pq.poll();
                    pq.offer(nums[j]);
                    }
                 
                }
            }
        
        int w = 0;
        while(!pq.isEmpty()){
            res[w] = pq.poll();
            w++;
        }
        return res;
    }
}