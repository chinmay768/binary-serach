public class FindPeakElement {

    public static int peakElementIdxNaive(int[] nums){
        int n = nums.length;
        if(n == 1) return 0;
        for(int i = 0; i < nums.length; i++){
            if((i == 0 || nums[i] > nums[i - 1]) && (i == n -1 || nums[i] > nums[i + 1])){
                return i;
            }
        }

        return -1;
    }

    public static int peakElement(int[] nums){
        int n = nums.length;

        if(n == 1) return 0;
        if(nums[0] > nums[1]) return 0;
        if(nums[n - 1] > nums[n - 2]) return n - 1;

        int low = 1;
        int high = nums.length - 2;
        while (low <= high){
            int mid = low + (high - low) / 2;

            if(nums[mid] > nums[mid - 1] && nums[mid] > nums[mid + 1])
                return mid;

            if(nums[mid] > nums[mid - 1]) low = mid + 1;
            else high = mid - 1;
        }

        return  -1;
    }

    public static void main(String[] args) {
        int[] nums = {0,1,2,3,5,6,4};
        System.out.println(peakElement(nums));
    }
}
