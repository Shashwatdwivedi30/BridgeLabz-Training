// Problem number 26: Remove Duplicates from Sorted Array
class RemoveDuplicates {
    public int removeDuplicates(int[] nums) {
        int l=0;
        for(int i=1;i<nums.length;i++){
            if(nums[l]!=nums[i]) {
                l++;
                nums[l] = nums[i];
            }
        }
        return l+1;
    }
}