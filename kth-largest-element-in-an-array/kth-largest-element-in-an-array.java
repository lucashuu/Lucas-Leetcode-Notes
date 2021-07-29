// 利用
class Solution {
    public int findKthLargest(int[] nums, int k) {
    //利用快排的思想找第n-k 小的数 
    //套用九章的快排模板
        if(nums.length < 1 || nums == null){
            return -1;
        }
        // 1 2 3 4 5 6
        // 6 - 2 = 4 
        int kthElement = partition(nums, 0, nums.length - 1, nums.length - k);
        return kthElement;
    }
    public int partition (int[] nums, int start, int end, int k){
        if(start >= end){
            return nums[k];
        }
        int left = start;
        int right = end;
        int pivot = nums[(start + (end - start) / 2)];
        while(left <= right){
            while(left <= right && nums[left] < pivot){
                left++;
            }
            while(left <= right && nums[right] > pivot){
                right--;
            }
            if(left <= right){
                swap(nums, left, right);
                left++;
                right--;
            }
        }
        if(k >= left){
                    return partition(nums, left, end, k);
                }
        if(k <= right){
                    return partition(nums, start, right, k);
                }
            return nums[k];
    }
    public void swap(int[] nums, int l, int r){
        int temp = nums[l];
        nums[l] = nums[r];
        nums[r] = temp;
    }
}