// O(n) 的时间内完成所以不能从头部开始比较 从尾部开始比较
//如果B 的 数比 A 的大则把 B 的num 放进 array

class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if(nums1.length == 0 || nums1 == null){
            return;
        }
        int index = m + n - 1;
        int idnex2 = n - 1;
        while(m > 0 && n > 0){
            if(nums1[m - 1] > nums2[n - 1]){
                nums1[index] = nums1[m - 1];
                m--;
            }else{
                nums1[index] = nums2[n - 1];
                n--;
            }
            index--;
        }
        while(n > 0){
            nums1[index] = nums2[n - 1];
            n--;
            index--;
        }
        return;
    }
}