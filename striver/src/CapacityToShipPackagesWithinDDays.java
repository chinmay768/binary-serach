import java.util.Arrays;

public class CapacityToShipPackagesWithinDDays {

    public static int getMax(int[] arr){
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < arr.length; i++){
            max = Math.max(max, arr[i]);
        }
        return max;
    }

    public static int shipWithinDaysNaive(int[] weights, int days) {
        int max = getMax(weights);
        int sum = Arrays.stream(weights).sum();

        for(int cap = max; cap <= sum; cap++){
            if(getDaysToShip(weights, cap) <= days) return cap;
        }

        return -1;
    }

    public static int shipWithinDays(int[] weights, int days) {
        int low = getMax(weights);
        int high = Arrays.stream(weights).sum();
        int res = -1;

        while (low <= high){
            int mid = low + (high - low) / 2;
            int reqDays = getDaysToShip(weights, mid);
            if(reqDays <= days){
                res = mid;
                high = mid - 1;
            }
            else{
                low = mid + 1;
            }
        }

        return res;
    }

    public static int getDaysToShip(int[] weights, int capacity) {
        int days = 1;
        int currWeight = 0;
        for(int i = 0; i < weights.length; i++){
            currWeight += weights[i];
            if(currWeight > capacity){
                days++;
                currWeight = weights[i];
            }
        }

        return days;
    }

    public static void main(String[] args) {
        int[] weights = {1,2,3,4,5,6,7,8,9,10};
        int days = 5;

        System.out.println(shipWithinDays(weights, days));
    }
}
