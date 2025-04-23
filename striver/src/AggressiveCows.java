import java.util.*;

public class AggressiveCows {

    public static int[] findMinMax(int[] arr){
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for(int i = 0; i< arr.length; i++){
            max = Math.max(max, arr[i]);
            min = Math.min(min, arr[i]);
        }

        return new int[] {min, max};
    }

    public static int maxDistNaive(int[] arr, int k){
        Arrays.sort(arr);

        int min = arr[0];
        int max = arr[arr.length - 1];

        int maxDist = -1;

        for(int i = 1; i <= (max - min); i++){
            if(possibleCows(arr, i) >= k) maxDist = i;
        }

        return maxDist;
    }

    public static int maxDist(int[] arr, int k){
        Arrays.sort(arr);
        int min = 1;
        int max = arr[arr.length - 1] - arr[0];
        int maxDist = -1;

        while (min <= max){
            int mid = min + (max - min) / 2;

            if(possibleCows(arr, mid) >= k){
                maxDist = mid;
                min = mid + 1;
            }else {
                max = mid - 1;
            }
        }

        return maxDist;
    }

    public static int possibleCows(int[] arr, int dist){
        int cows = 1;
        int lastPlacedIdx = 0;
        for(int i = 1; i < arr.length; i++){
            if(arr[i] - arr[lastPlacedIdx] >= dist) {
                cows++;
                lastPlacedIdx = i;
            }
        }

        return cows;
    }

    public static void main(String[] args) {
        // Given an input arr containing all the possible coordinates of stalls.
        // Task is to place cows in these positions such that they are as far way from each other as possible
        // i.e min dist b/w cows is max
        int[] arr = {0, 3, 4, 7, 10, 9};
        int k = 4;
        System.out.println(maxDist(arr, k));
    }
}
