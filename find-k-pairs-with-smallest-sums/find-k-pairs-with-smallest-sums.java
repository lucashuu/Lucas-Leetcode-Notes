class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        // max heap  里面存 最小的k组 combination 
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>(k, new Comparator<int[]>(){
            public int compare (int[] a, int[] b){
                int a1 = a[0]  + a[1];
                int b1 = b[0] + b[1];
                return b1 - a1;
            }
        });
        for(int i = 0; i < nums1.length; i++){
            for(int j = 0; j < nums2.length; j++){
                //if the next number is bigger than previous one
                // can not be in heap
                if(pq.size() < k){
                    pq.offer(new int[]{nums1[i], nums2[j]});
                }else{
                   if(compare(pq.peek(), new int[]{nums1[i], nums2[j]}) >= 0)
                    {
                        break;
                    }
                    pq.offer(new int[]{nums1[i], nums2[j]});
                    if(pq.size() >= k){
                     pq.poll();
                    } 
                }
            }
         }
        List<List<Integer>> res = new ArrayList<>();
        while(!pq.isEmpty()){
            List<Integer> temp = new ArrayList<>();
            int[] t = pq.poll();
            temp.add(t[0]);
            temp.add(t[1]);
            res.add(temp);
        }
        return res;
      }
    
    public int compare(int[] a, int[] b){
        int a1 = a[0]  + a[1];
                int b1 = b[0] + b[1];
                return b1 - a1;
        
    }
}