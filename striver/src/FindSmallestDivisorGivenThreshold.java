public class FindSmallestDivisorGivenThreshold {

    public static int findMax(int[] nums){
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++){
            max = Math.max(max, nums[i]);
        }
        return max;
    }

    public static int findDivisionSum(int[] nums, int divisor){
        int sum = 0;

        for(int i = 0; i < nums.length; i++){
            sum += (int) Math.ceil((nums[i] / (divisor * 1D)));
        }
        return sum;
    }

    // TC: O(n) + O(max * n)
    public static int smallestDivisorNaive(int[] nums, int threshold) {
        int max = findMax(nums);

        for(int i = 1; i <= max; i++){
            if(findDivisionSum(nums, i) <= threshold) return i;
        }

        return -1;
    }

    // TC: O(log(max) * n)
    public static int smallestDivisor(int[] nums, int threshold){
        int low = 1;
        int high = findMax(nums);
        int smallestDivisor = Integer.MAX_VALUE;

        while (low <= high){
            int mid = low + (high - low) / 2;

            if(findDivisionSum(nums, mid) <= threshold){
                smallestDivisor = Math.min(smallestDivisor, mid);
                high = mid - 1;
            }else {
                low = mid + 1;
            }
        }

        return smallestDivisor;
    }

    public static void main(String[] args) {
        int[] nums = {44,22,33,11,1};
        System.out.println(smallestDivisor(nums, 5));
    }
}
