import java.util.Arrays;

public class FindPeakElement2 {

    public static int[] findPeakGrid(int[][] mat) {
        int low = 0;
        int high = mat[0].length - 1;

        while (low <= high){
            int mid = low + (high - low) / 2;

            int maxElmIdx = findMaxIdxInCol(mat, mid); // Gets the max elm row

            int left = mid - 1 >= 0? mat[maxElmIdx][mid - 1] : -1;
            int right = mid + 1 < mat[0].length? mat[maxElmIdx][mid + 1] : -1;

            if(mat[maxElmIdx][mid] > left && mat[maxElmIdx][mid] > right)
                return new int[] {maxElmIdx, mid};
            else if( mat[maxElmIdx][mid] < left)
                high = mid - 1;
            else
                low = mid + 1;
        }

        return new int[]{-1, -1};
    }

    public static int findMaxIdxInCol(int[][] mat, int colIdx){
        int maxIdx = -1;
        int maxElm = Integer.MIN_VALUE;
        for(int i = 0; i < mat.length; i++){
            if(mat[i][colIdx] > maxElm){
                maxElm = mat[i][colIdx];
                maxIdx = i;
            }
        }

        return maxIdx;
    }

    public static void main(String[] args) {
        int[][] matrix = {{1,4},{3,2}};

        System.out.println(Arrays.toString(findPeakGrid(matrix)));
    }
}
