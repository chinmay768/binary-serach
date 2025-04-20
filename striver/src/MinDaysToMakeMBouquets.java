public class MinDaysToMakeMBouquets {

    public static int findMax(int[] arr){
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < arr.length; i++){
            max = Math.max(max, arr[i]);
        }

        return max;
    }

    public static int possibleBouquets(int[] bloomday, int day, int bouquetSize){
        int count = 0;
        int bouquetsCount = 0;

        for(int i = 0; i < bloomday.length; i++){
            if(bloomday[i] <= day) count++;
            else {
                bouquetsCount += count / bouquetSize;
                count = 0;
            }
        }

        bouquetsCount += count / bouquetSize;
        return bouquetsCount;
    }

    public static int minDaysNaive(int[] bloomDay, int m, int k) {
        int maxDays = findMax(bloomDay);

        for(int i = 1; i <= maxDays; i++){
            if(possibleBouquets(bloomDay, i, k) >= m) return i;
        }

        return -1;
    }

    public static int minDays(int[] bloomDay, int m, int k){
        int low = 1;
        int high = findMax(bloomDay);
        int ans = -1;

        while (low <= high){
            int mid = low + (high - low) / 2;

            if(possibleBouquets(bloomDay, mid, k) >= m){
                ans = mid;
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }


        return ans;
    }


    public static void main(String[] args) {
        int[] bloomDay = {1,10,3,10,2};
        int m = 3; // No of bouquets
        int k = 1; // Size of bouquets

        System.out.println(minDays(bloomDay, m, k));
    }
}
