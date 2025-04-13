import java.util.Arrays;

public class FirstAndLastOccurenceOfElmInSortedArray {

    //TC: O(N)
    public static int[] searchRangeNaive(int[] nums, int target) {
        int firstIdx = -1;
        int lastIdx = -1;

        for(int i = 0; i < nums.length; i++){
            if(nums[i] == target){
                if(firstIdx == -1) firstIdx = i;
                lastIdx = i;
            }
        }

        return new int[] {firstIdx, lastIdx};
    }

    public static int upperBoundItr(int[] arr, int target){
        int low = 0;
        int high = arr.length - 1;

        int ans = arr.length;

        while (low <= high){
            int mid = low + (high - low) / 2;

            if(arr[mid] > target){
                ans = mid;
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }

        return ans;
    }

    public static int lowerBoundItr(int[] arr, int target){
        int low = 0;
        int high = arr.length - 1;

        int ans = arr.length;

        while (low <= high){
            int mid = low + (high - low) / 2;

            if(arr[mid] >= target){
                ans = mid;
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }

        return ans;
    }

    // TC: O(2logn)
    // SC: O(1)
    public static int[] searchRange(int[] nums, int target) {
        int lb = lowerBoundItr(nums, target);

        if(lb == nums.length || nums[lb] != target)
            return new int[]{-1, -1};

        return new int[]{lb, upperBoundItr(nums, target) - 1};
    }

    public static int firstOccurence(int[] nums, int target){
        int low = 0;
        int high = nums.length - 1;
        int firstIdx = -1;

        while (low <= high){
            int mid = low + (high - low) / 2;

            if (nums[mid] == target) {
                firstIdx = mid;
                high = mid - 1;
            }else if (nums[mid] < target){
                low = mid + 1;
            }else {
                high = mid - 1;
            }
        }

        return firstIdx;
    }

    public static int lastOccurence(int[] nums, int target){
        int low = 0;
        int high = nums.length - 1;
        int lastIdx = -1;

        while (low <= high){
            int mid = low + (high - low) / 2;

            if (nums[mid] == target) {
                lastIdx = mid;
                low = mid + 1;
            }else if (nums[mid] < target){
                low = mid + 1;
            }else {
                high = mid - 1;
            }
        }

        return lastIdx;
    }


    public static void main(String[] args) {
        int[] nums = {5,7,7,8,8,10};
        int target = 8;

        System.out.println(Arrays.toString(searchRange(nums, target)));

        int firstIdx = firstOccurence(nums, target);
        int lastIdx = lastOccurence(nums, target);
        System.out.println(firstIdx + " " + lastIdx);
    }
}
