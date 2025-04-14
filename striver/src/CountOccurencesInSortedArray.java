public class CountOccurencesInSortedArray {

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
        int[] arr = {1, 2, 2, 2, 2, 3, 8};

        int firstIdx = firstOccurence(arr, 1);
        if(firstIdx != -1)
            System.out.println(lastOccurence(arr,1) - firstIdx + 1);
        else
            System.out.println("Element not found!");
    }
}
