public class Search2DMatrix2 {

    //TC: O(nlogn)
    public static boolean searchMatrixNaive(int[][] matrix, int target){
        //Traverse each row and perform binary search on each row since the row is sorted
        return false;
    }


    //TC: O(n + m)
    public static boolean searchMatrix(int[][] matrix, int target) {
        int row = 0;
        int col = matrix[0].length - 1;

        while (row <= matrix.length - 1 && col >= 0){
            if(matrix[row][col] == target) return true;
            else if(matrix[row][col] > target){
                col--;
            }else{
                row++;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] matrix = {{1,4,7,11,15},{2,5,8,12,19},{3,6,9,16,22},{10,13,14,17,24},{18,21,23,26,30}};

        System.out.println(searchMatrix(matrix, 14));
    }
}
