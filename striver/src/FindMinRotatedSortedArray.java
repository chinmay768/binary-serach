public class FindMinRotatedSortedArray {

    public static int findMin(int[] nums) {
        int min = Integer.MAX_VALUE;

        int start = 0;
        int end = nums.length -1;

        while (start <= end){
            int mid = start + (end - start) / 2;

            if(nums[mid] <= nums[end]){ //Right Sorted
                min = Math.min(min, nums[mid]);
                end = mid - 1;
            }else{
                min = Math.min(min, nums[start]);
                start = mid + 1;
            }
        }

        return min;
    }

    public static void main(String[] args) {
        int[] arr = {4,5,6,7,0,1,2};

        System.out.println(findMin(arr));
    }
}
