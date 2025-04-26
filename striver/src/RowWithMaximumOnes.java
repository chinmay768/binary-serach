public class RowWithMaximumOnes {

    public static int rowWithMax1Naive(int[][] matrix){
        int maxRowIdx = -1;
        int maxCount = 0;
        for(int i = 0; i < matrix.length; i++){
            int currCount = 0;
            for(int j = 0; j < matrix[i].length; j++){
                if(matrix[i][j] == 1) currCount++;
            }
            if(currCount > maxCount) {
                maxCount = currCount;
                maxRowIdx = i;
            }
        }

        return maxRowIdx;
    }

    public static int lowerBound(int[] arr, int target){
        int ans = -1;

        int low = 0;
        int high = arr.length - 1;

        while (low <= high){
            int mid = low + (high - low) / 2;

            if(arr[mid] >= target) {
                ans = mid;
                high = mid - 1;
            }else {
                low = mid + 1;
            }
        }

        return ans;
    }

    public static int getRowWithMaxOnes(int[][] matrix){
        int ans = -1;
        int maxOnes = 0;

        for(int i = 0; i < matrix.length; i++){
            int lowerBound = lowerBound(matrix[i], 1);
            if(lowerBound != -1){
                int currOneCount = matrix[i].length - lowerBound;

                if(currOneCount > maxOnes){
                    maxOnes = currOneCount;
                    ans = i;
                }
            }
        }

        return ans + 1;
    }

    public static void main(String[] args) {
        int[][] arr = {
                {0, 0, 0, 1, 1, 1, 1},
                {0, 0, 1, 1, 1, 1, 1},
                {0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 1, 1}
        };

        System.out.println(getRowWithMaxOnes(arr));
//        System.out.println(lowerBound(arr[2], 1));
    }
}
