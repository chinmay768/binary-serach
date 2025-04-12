public class UpperBound {

    // TC: O(logn) logbase2 n
    public static int upperBoundRec(int[] arr, int target, int low, int high, int ans){
        if(low > high) return ans;

        int mid = low + (high - low) / 2;

        if(arr[mid] > target){
            ans = mid;
            return upperBoundRec(arr, target, low, mid - 1, ans);
        }

        return upperBoundRec(arr, target, mid + 1, high, ans);
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

    // Remember if there are duplicates then you have to return the first matching idx
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 3, 5, 8, 8, 10, 10, 11};

        System.out.println(upperBoundRec(arr, 5, 0, arr.length - 1, arr.length));

        System.out.println(upperBoundItr(arr, 5));
    }
}
