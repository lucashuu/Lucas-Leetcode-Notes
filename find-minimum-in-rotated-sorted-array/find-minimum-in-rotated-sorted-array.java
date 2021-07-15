//二分找旋转点
//判断 nums[0] 和 nums[旋转点]
class Solution {
    public int findMin(int[] nums) {
        if(nums.length == 0 || nums == null){
            return -1;
        }
        if(nums.length == 1){
            return nums[0];
        }
        int l = 0; int r = nums.length - 1;
        while(l + 1 < r){
            int mid = l + (r - l) / 2;
            if(nums[mid] >= nums[0]){
                l = mid;
            }else{
                r = mid;
            }
        }
        System.out.println(l);
        return Math.min(nums[0], nums[l + 1]);
    }
}