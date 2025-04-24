import java.util.Arrays;

public class SplitArrayLargestSum {

    public static int findMax(int[] arr){
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < arr.length; i++){
            max = Math.max(max, arr[i]);
        }
        return max;
    }

    public static int largestSumNaive(int[] arr, int k){
        int max = findMax(arr);
        int sum = Arrays.stream(arr).sum();

        for(int i = max; i <= sum; i++){
            if(possibleSubarrays(arr, i) == k) return i;
        }

        return max;
    }

    public static int largestSum(int[] arr, int k){
        int low = findMax(arr);
        int high = Arrays.stream(arr).sum();
        int res = high;
        while (low <= high){
            int mid = low + (high - low) / 2;

            int partitions = possibleSubarrays(arr, mid);
            if (partitions <= k) { // Here <= works bc if capacity is mid then we can split the subarray again and be sure that
                res = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return res;
    }

    public static int possibleSubarrays(int[] arr, int capacity) {
        int subarrayCount = 1;
        int currSum = 0;
        for(int i = 0; i < arr.length; i++){
            if(currSum + arr[i] <= capacity) currSum += arr[i];
            else {
                subarrayCount++;
                currSum = arr[i];
            }
        }

        return subarrayCount;
    }

    public static void main(String[] args) {
        int[] arr = {2,3,1,1,1,1,1};
        int k = 5;

        System.out.println(largestSum(arr, k));
    }
}
