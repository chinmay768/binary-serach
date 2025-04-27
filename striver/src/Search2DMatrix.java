public class Search2DMatrix {

    //TC: O(n) + O(logn)
    public static boolean searchMatrixNaive(int[][] matrix, int target) {
        for(int i = 0; i < matrix.length; i++){
            if(matrix[i][0] <= target && matrix[i][matrix[i].length - 1] >= target){
                return binarySeach(matrix[i], target);
            }
        }
        return false;
    }

    public static boolean searchMatrix(int[][] matrix, int target) {
        int low = 0;
        int high = (matrix.length * matrix[0].length) - 1;

        while (low <= high){
            int mid = low + (high - low) / 2;
            int midRow = mid / matrix[0].length;
            int midCol = mid % matrix[0].length;

            if(matrix[midRow][midCol] == target) return true;
            else if(matrix[midRow][midCol] < target){
                low = mid + 1;
            }else {
                high = mid - 1;
            }
        }

        return false;
    }

    public static boolean binarySeach(int[] arr, int target){
        int low = 0;
        int high = arr.length - 1;

        while (low <= high){
            int mid = low + (high - low) / 2;

            if(arr[mid] == target) return true;
            else if(arr[mid] < target){
                low = mid + 1;
            }else {
                high = mid - 1;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        int[][] matrix = {{1,3,5,7},{10,11,16,20},{23,30,34,60}};

        System.out.println(searchMatrix(matrix, 16));
    }
}
