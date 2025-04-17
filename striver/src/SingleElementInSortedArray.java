public class SingleElementInSortedArray {
    // Edge Cases
    // 1. If the array contains only 1 element
    // 2. If mid comes at first or last idx
    // 3.

    public static int findSingleElm(int[] nums){
        int n = nums.length;
        if(n == 1) return nums[0];

        if(nums[0] != nums[1])  return nums[0];
        if(nums[n - 1] != nums[n - 2]) return nums[n - 1];

        int low = 1;
        int high = nums.length - 2;

        while (low <= high){
            int mid = low + (high - low) / 2;

            if(nums[mid] != nums[mid - 1] && nums[mid] != nums[mid + 1]) return nums[mid];

            if(mid % 2 == 0){
                if(nums[mid] != nums[mid + 1]) high = mid - 1;
                else low = mid + 1;
            }else {
                if(nums[mid] != nums[mid - 1]) high = mid - 1;
                else low = mid + 1;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {3,3,7,7,10,11,11};

        System.out.println(findSingleElm(nums));
    }
}
