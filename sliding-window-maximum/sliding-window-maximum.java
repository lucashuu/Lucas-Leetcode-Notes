class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] res = new int[nums.length - k + 1];
        Deque<Integer> q = new LinkedList<>();
        
        for(int right = 0; right < nums.length; right++){
            while(!q.isEmpty() && nums[right] >= nums[q.peekLast()]){
                q.removeLast();
            }
                q.offerLast(right);
            int left = right - k + 1;
            if(q.peekFirst() < right - k + 1){
                
                q.removeFirst();
            }
            if(right + 1 >= k){
                res[left] = nums[q.peekFirst()];
            }
        }
        return res;
    }
}