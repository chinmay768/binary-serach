public class KthMissingPositiveNumber {

    public static int findMax(int[] nums){
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < nums.length; i++){
            max = Math.max(max, nums[i]);
        }
        return max;
    }

    public static int kthMissingNumberNaive(int[] arr, int k){
        int missingNum = k;

        for (int i = 0; i < arr.length; i++){
            if(arr[i] <= missingNum){
                missingNum++;
            }else break;
        }
        return missingNum;
    }

    public static int kthMissingNumber(int[] arr, int k){
        int low = 0;
        int high = arr.length - 1;

        while (low <= high){
            int mid = low + (high - low) / 2;

            if(arr[mid] - (mid + 1) < k){ // Don't use <= here
                low = mid + 1;
            }else {
                high = mid - 1;
            }
        }

        // This sometimes gives out of bounds exception
//        int num = arr[high];
//        int missingCount = arr[high] - (high + 1);
//
//        int needMore = k - missingCount;
//        return num + needMore;

        return k + high + 1;
    }

    public static void main(String[] args) {
//        int[] arr = {2,3,4,7,11};
        int[] arr2 = {2};

        int k = 1;

        System.out.println(kthMissingNumber(arr2, k));
    }
}
