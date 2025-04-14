public class SearchInSortedRotatedArray {

    public static int search(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;

        while (start <= end){
            int mid = start + (end - start) / 2;

            if(nums[mid] == target) return mid;

            if(nums[mid] < nums[end]){ // Right part is sorted
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

        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {4,5,6,7,0,1,2};

        System.out.println(search(arr, 1));
    }
}
