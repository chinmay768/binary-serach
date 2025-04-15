public class SearchInRotatedSortedArray2 {

    public static boolean search(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;

        while (start <= end){
            int mid = start + (end - start) / 2;

            if(nums[mid] == target) return true;

            if(nums[start] == nums[mid] && nums[mid] == nums[end]){
                start++;
                end--;
                continue;
            }

            if(nums[mid] <= nums[end]){ // Right part is sorted NOTE: In this we are adding equals symbol cause there are duplicates
                if(target > nums[mid] && target <= nums[end]){
                    start = mid + 1;
                }else{
                    end = mid - 1;
                }
            }else{
                if(target >= nums[start] && target < nums[mid]){
                    end = mid - 1;
                }else {
                    start = mid + 1;
                }
            }
        }

        return false;
    }

    public static void main(String[] args) {
        int[] arr = {3, 3, 3, 1, 2, 3, 3, 3, 3, 3, 3, 3};

        System.out.println(search(arr, 2));
    }
}
