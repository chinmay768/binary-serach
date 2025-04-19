public class KokoEatingBananas {

    public static int findMax(int[] arr){
        int max = Integer.MIN_VALUE;

        for(int i = 0; i < arr.length; i++){
            max =  Math.max(max, arr[i]);
        }
        return max;
    }

    public static int calculateTotalHours(int[] v, int hourly) {
        int totalH = 0;
        int n = v.length;
        //find total hours:
        for (int i = 0; i < n; i++) {
            totalH += Math.ceil((double)(v[i]) / (double)(hourly));
        }
        return totalH;
    }

    public static int minEatingSpeedNaive( int[] piles, int h){
        int maxPile = findMax(piles);


        for(int i = 1; i <= maxPile; i++){
            if(calculateTotalHours(piles, i) <= h) return i;
        }

        return maxPile; // Dummy return stmt
    }

    public static int minEatingSpeed(int[] piles, int h){
        int start = 1;
        int end = findMax(piles);
        int minEatingSpeed = Integer.MAX_VALUE;

        while (start <= end){
            int mid = start + (end - start) / 2; // Mid is eating speed

            int totalHours = calculateTotalHours(piles, mid);
            if(totalHours <= h)  {
                minEatingSpeed = mid;
                end = mid - 1;
            }else {
                start = mid + 1;
            }
        }

        return minEatingSpeed;
    }

    public static void main(String[] args) {
        int[] arr = {7, 15, 6, 3};
        System.out.println(minEatingSpeed(arr, 8));
    }
}
