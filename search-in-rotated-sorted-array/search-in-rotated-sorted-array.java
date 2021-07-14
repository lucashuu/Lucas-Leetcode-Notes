//0 1 2 4 5 6 7//4 5 6 7 0 1 2 find 7 is > 0
//则4 - 7 一段有序数组 0 - 2有序数组  找到break point A[0] < 左边元素 A[0] > 右边元素
class Solution {
    public int search(int[] nums, int target) {
        if(nums.length == 0 || nums == null){
            return -1;
        }
        int p = findBreakPoint(nums);
        if(target >= nums[0]){
            return bs(nums, target, 0, p);
        }else{
            return bs(nums,target, p, nums.length - 1);
        }
    }
    public int findBreakPoint(int[] nums){
        int start = 0; 
        int end = nums.length - 1;
        while(start + 1 < end){
            int mid = start + (end - start) / 2;
            if(nums[mid] > nums[0]){
                start = mid;
            }else{
                end = mid;
            }
        }
        int index;
        index = nums[start] < nums[0] ? start : end ;
        return index;
    }
    public int bs(int[] A, int target, int lo, int hi){
         while (lo + 1 < hi) {
            int md = lo + (hi - lo) / 2;
            if (A[md] == target) {
                lo = md;
            } else if (A[md] < target) {
                lo = md;
            } else {
                hi = md;
            }
        }

        if (A[lo] == target) {
            return lo;
        }
        if (A[hi] == target) {
            return hi;
        }
        return -1;
    }
    }
