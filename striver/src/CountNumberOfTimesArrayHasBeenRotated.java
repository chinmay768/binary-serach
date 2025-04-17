public class CountNumberOfTimesArrayHasBeenRotated {

    public static int findMinIdx(int[] nums) {
        int min = Integer.MAX_VALUE;
        int minIdx = -1;

        int start = 0;
        int end = nums.length -1;

        while (start <= end){
            int mid = start + (end - start) / 2;

            if(nums[mid] <= nums[end]){ //Right Sorted
                if(min > nums[mid]){
                    min = nums[mid];
                    minIdx = mid;
                }
                end = mid - 1;
            }else{
                if(min > nums[start]){
                    min = nums[start];
                    minIdx = start;
                }
                start = mid + 1;
            }
        }

        return minIdx;
    }

    public static void main(String[] args) {
        int[] arr = {4,5,6,7,0,1,2};

        System.out.println(findMinIdx(arr)); // The min idx is also the no of times the array has been rotated
    }
}
