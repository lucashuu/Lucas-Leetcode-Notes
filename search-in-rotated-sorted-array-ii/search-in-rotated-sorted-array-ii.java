//跟Rotated Sorted Array I 的区别 
//数组会有重复 such as 0 1 2 4 4 4 5 6 6 7
//有3种旋转过后的可能性
// 0 1 2 4 4 4 | 5 6 6 7 -> 5 6 6 7 0 1 2 4 4 4 一部分 <= 4 一部分 > 4 
// 0 1 2 | 4 4 4 5 6 6 7 -> 4 4 4 5 6 6 7 0 1 2  一部分大于4 一份小于4
// 0 1 2 4 | 4 4  5 6 6 7 -> 4 4 5 6 6 7 0 1 2      4 失调二分的单调性
// 预处理使 array 重新恢复单调性
// 找break point 两次二分
class Solution {
    public boolean search(int[] nums, int target) {
        if(nums.length == 0 || nums == null){
            return false;
        }
        if(nums.length == 1){
            return nums[0] == target;
        }
        int l = 0; int r = nums.length -1;
        while(nums[0] == nums[r] && l < r){
            r--;
        }
        int b = r;
        while(l + 1< r){
            int mid = l + (r - l) / 2;
            if(nums[mid] >= nums[0]){
                l = mid;
            }else{
                r = mid;
            }
        }
        int p = l + 1;
        System.out.println(p);
        System.out.println(b);
        if(target >= nums[0] && target <= nums[p - 1]){
            return findnum(nums, 0, p - 1, target);
        }else if(target >= nums[p] && target <= nums[b]){
            return findnum(nums, p , b, target);
        }else{
            return false;
        }
    }
    public boolean findnum(int[] nums, int l, int r, int target){
        if(l == r){
            return nums[l] == target;
        }
        while(l + 1 < r){
            int mid = l + (r - l) / 2;
            if(nums[mid] == target){
                l = mid;
                return true;
            }else if(nums[mid] < target){
                l = mid;
            }else{
                r = mid;
            }
        }
        if(nums[l] == target || nums[r] == target){
            return true;
        }else{
            return false;
        }
    }
}