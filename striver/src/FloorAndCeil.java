public class FloorAndCeil {
    //Floor is largest elm in array <= x
    //Ceil is smallest elm in array >= x  (Similar to lower bound)

    public static int floor(int[] arr, int target){
        int left = 0;
        int right = arr.length - 1;
        int ans = -1;


        while (left <= right){
            int mid = left + (right - left) / 2;

            if(arr[mid] <= target){
                ans = mid;
                left = mid + 1;
            }else{
                right = mid - 1;
            }
        }

        return ans;
    }

    public static int ceil(int[] arr, int target){
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

    public static void main(String[] args) {

    }
}
