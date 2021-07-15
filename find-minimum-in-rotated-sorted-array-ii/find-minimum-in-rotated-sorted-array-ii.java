//对数组进行预处理，让其具有二分单调性,次题和Seach in Roated Array II 一个思路
//找到break point 比较nums[0] 和 break point 点的大小 找到最小值
class Solution {
    public int findMin(int[] nums) {
        if(nums.length == 0 || nums == null){
            return -1;
        }
        if(nums.length == 1){
            return nums[0];
        }
        int l = 0; int r = nums.length - 1;
        while(nums[0] == nums[r] && r > l){
            r--;
        }
        while(l + 1 < r){
            int mid = l + (r - l) / 2;
            if(nums[mid] >= nums[0]){
                l = mid;
            }else {
                r = mid;
            }
        }
        return Math.min(nums[0],nums[l + 1]);
    }
}