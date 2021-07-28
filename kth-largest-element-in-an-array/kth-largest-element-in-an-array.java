class Solution {
    // partition 模板调用
    // quick sort
    // 递归结束条件 when  m + 1 == k
    public int findKthLargest(int[] nums, int k) {
        if(nums.length == 0 || nums == null){
            return -1;
        }
        if(nums.length == 1){
            return nums[0];
        }
        return partition(nums, 0, nums.length - 1, nums.length - k);
    }
    public int partition(int[] nums, int start, int end, int k){
        if(start >= end){
            return nums[k];
        }
        int left = start; int right = end;
        int pivot = nums[(start + (end - start) / 2)];
        
        while (left <= right){
            while(left <= right && nums[left] < pivot){
                left++;
            }
            while(right >= left && nums[right] > pivot){
                right--;
            }
            if(left <= right){
                swap(nums, left, right);
                left++;
                right--;
            }
        }
        if(k <= right ){
            return partition(nums, start, right, k);
        }
        if (k >= left) {
            return partition(nums,left, end, k);
        }
        return nums[k];
    }
    public void swap(int[] nums, int i, int j){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
       
        
    }
