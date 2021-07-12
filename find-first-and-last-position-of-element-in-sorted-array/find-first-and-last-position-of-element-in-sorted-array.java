//两次二分查找
//第一次二分查找左边界 第二次右边界 
class Solution {
    public int[] searchRange(int[] nums, int target) {
       int[] result= new int[]{-1, -1};
        if(nums.length == 0 || nums == null){
            return result;
        }
        int lb = -1; int up = nums.length;
        while(lb + 1 < up){
            int mid = lb + (up - lb) / 2;
            if(nums[mid] < target){
                lb = mid;
            }
            else{
                up = mid;
            }
        }
        if((lb + 1 < nums.length) && (nums[lb + 1] == target)){
            result[0] = lb + 1; 
        }else{
            result[0] = -1;
            result[1] = -1;
            // target is not in the array
            return result;
        }
        lb = -1;
        up = nums.length;
        while (lb + 1 < up){
            int mid = lb + (up - lb) / 2;
            if (nums[mid] > target) {
                up = mid;
            } else {
                lb = mid;
            }
        }
        // target must exist in the array
        result[1] = up - 1;
        return result;
    }
}